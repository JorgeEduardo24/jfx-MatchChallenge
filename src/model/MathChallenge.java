package model;

public class MathChallenge {

	private Player root;
	
	public MathChallenge() {
		
	}
	
	public Player getRoot() {
		return root;
	}

	public void setRoot(Player root) {
		this.root = root;
	}

	public void addScore(Player newPlayer) {
		if(root==null) {
			root = newPlayer;
		}else {
			addScore(root, newPlayer);
		}
	}

	private void addScore(Player current, Player newPlayer) {
		if(newPlayer.getScore()<=current.getScore()) {
			if(current.getLeft()==null) {
				current.setLeft(newPlayer);
				newPlayer.setUp(current);
			}else {
				addScore(current.getLeft(), newPlayer);
			}
		}else {
			if(current.getRight()==null) {
				current.setRight(newPlayer);
				newPlayer.setUp(current);
			}else {
				addScore(current.getRight(), newPlayer);
			}
		}
	}
	
	public Player searchScore(int score) {
		if(root==null) {
			return null;
		}else {
			return searchScoreIterative(root, score);
		}
	}

	private Player searchScoreIterative(Player current, int score) {
		Player found = null;
		while(current!=null && found==null) {
			if(current.getScore()==score) {
				found = current;
			}else if(score > current.getScore()) {
				current = current.getRight();
			}else {
				current = current.getLeft();
			}
		}
		return found;
	}
	
	
	
	public void removeScore(int score) {
		Player playerRemove = searchScore(score);
		removeScore(playerRemove);
	}
	
	private void removeScore(Player playerRemove) {
		if(playerRemove != null) { 
			//CASE 1: The node is a leaf
			if(playerRemove.getLeft() == null && playerRemove.getRight() == null) { 
				if(playerRemove == root) { 
					root = null;
				}else if(playerRemove == playerRemove.getUp().getLeft()) {
					playerRemove.getUp().setLeft(null);
				}else {
					playerRemove.getUp().setRight(null);
				}
				
				//CASE 2: The node has one children 
			}else if(playerRemove.getLeft()==null || playerRemove.getRight()==null) {
				Player child;
				if(playerRemove.getLeft()!=null) { 
					child = playerRemove.getLeft();
				}else {
					child = playerRemove.getRight();
				}
				child.setUp(playerRemove.getUp());
				if(playerRemove==root) {
					root = child;
				}else if(playerRemove==playerRemove.getUp().getLeft()) {
					playerRemove.getUp().setLeft(child); 
				}else {
					playerRemove.getUp().setRight(child); 
				}
			}
			
			//CASE 3: The node has two children
			else {
				Player succesor = min(playerRemove.getRight());
				playerRemove.setName(succesor.getName());
				playerRemove.setScore(succesor.getScore());
				removeScore(succesor);
			}
		}
	}
	
	public Player min(Player current) {
		if(current.getLeft()==null) {
			return current;
		}else {
			return min(current.getLeft());
		}
	}
	
}
