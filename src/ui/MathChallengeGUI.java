package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.MathChallenge;
import model.Player;

public class MathChallengeGUI {
	
	private Player player;
	private MathChallenge mathChallenge;
	private Timeline time;
	private List<Player> players;
	
	private final Integer startTimeQ1 = 10;
	private Integer secondsQ1 = startTimeQ1;
	
	private final Integer startTimeQ2 = 10;
	private Integer secondsQ2 = startTimeQ2;
	
	private final Integer startTimeQ3 = 10;
	private Integer secondsQ3 = startTimeQ3;
	
	private final Integer startTimeQ4 = 10;
	private Integer secondsQ4 = startTimeQ4;
	
	public MathChallengeGUI() {
		mathChallenge = new MathChallenge();
		players = new ArrayList<Player>();
	}
	
	private Stage mainStage;

	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	
	//***************************** ATRIBUTES ********************
	
	//............ WELCOME ..........
	@FXML
    private TextField txtEnterPlayer;
	
	
	//............ Question 1 ........
	
	@FXML
    private Label lblTimerQ1;

    @FXML
    private Label lblScoreQ1;
    
    
    //............ Question 2 ........
    
    @FXML
    private Label lblTimerQ2;

    @FXML
    private Label lblScoreQ2;
    
    
    //........... Question 3 .........
    
    @FXML
    private Label lblTimerQ3;

    @FXML
    private Label lblScoreQ3;
    
    
    
    //.......... Question 4 ..........
    
    @FXML
    private Label lblTimerQ4;

    @FXML
    private Label lblScoreQ4;
    
   
    //.......... GameScore ...........
    
    @FXML
    private Label lblFinalScore;
    
    
    //............. SCOREBOARD............
    
    @FXML
    private Label lblPodiumName1;

    @FXML
    private Label lblPodiumName2;

    @FXML
    private Label lblPodiumName3;

    @FXML
    private Label lblPodiumName4;

    @FXML
    private Label lblPodiumName5;

    @FXML
    private Label lblPodiumScore1;

    @FXML
    private Label lblPodiumScore2;

    @FXML
    private Label lblPodiumScore3;
    
    
    //................. SEARCH_SCORE................
    
    @FXML
    private Label lblSearchedScore;

    @FXML
    private ComboBox<Player> cmbxPlayers;
    
    //................. REMOVE_SCORE ...............
    
    @FXML
    private ComboBox<String> cmbxPlayers2;


    
	//***************************** METHODS ***********************
	
	// ............. WELCOME ...............

    @FXML
    public void developerInfo(ActionEvent event) {
    	String message = "Math Challenge was developed by:"
    			+ "\nGloria Vanesa Vicuña"
    			+ "\nJorge Eduardo Jojoa";
    	informationAlert(message);
    	
    }

    @FXML
    public void play(ActionEvent event) throws IOException {    	
    	if(!txtEnterPlayer.getText().equals("")) {
    		player = new Player(txtEnterPlayer.getText());
    		players.add(player);
    		
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Question1.fxml"));
    		fxmlLoader.setController(this);
    		Parent root = fxmlLoader.load();
    		Scene scene = new Scene(root);

    		mainStage.setScene(scene);
    		mainStage.show();
    		doTimeQ1(lblTimerQ1);
    	}else {
    		String message = "Enter a player to start the game";
    		errorAlert(message);
    	}
    }
    
    //............ Question 1: Multiplicación ..........

    
    @FXML
    public void answer74(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	showSecondQuestion();
    	
    }

    @FXML
    public void answer84(ActionEvent event) throws IOException {
    	
		int score = player.getScore() + 10;
		player.setScore(score);
		time.stop();
		showSecondQuestion();
    	
    }

    @FXML
    public void answer86(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	
    	showSecondQuestion();
    	
    }

    @FXML
    public void answer92(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	showSecondQuestion();
    	
    }
    
    
    private void doTimeQ1(Label label) {
    	time = new Timeline();
    	time.setCycleCount(Timeline.INDEFINITE);
    	
    	if(time!=null) {
    		time.stop();
    	}
    	
    	KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
    		
    		@Override
    		public void handle(ActionEvent event){
    			secondsQ1--;
    			label.setText(secondsQ1.toString());
    			if(secondsQ1<=0) {
    				time.stop();
    				try {
						showSecondQuestion();
					} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    		}
    	});
    	time.getKeyFrames().add(frame);
    	time.playFromStart(); 
    	secondsQ1 = startTimeQ1;
    }
    
    public void showSecondQuestion() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Question2.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.show();
		
		lblScoreQ2.setText(String.valueOf(player.getScore()));
		doTimeQ2(lblTimerQ2);
    }
    
    private void doTimeQ2(Label label) {
    	time = new Timeline();
    	time.setCycleCount(Timeline.INDEFINITE);
    	
    	if(time!=null) {
    		time.stop();
    	}
    	
    	KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
    		
    		@Override
    		public void handle(ActionEvent event){
    			secondsQ2--;
    			label.setText(secondsQ2.toString());
    			if(secondsQ2<=0) {
    				time.stop();
    				try {
						showThirdQuestion();
					} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    		}
    	});
    	time.getKeyFrames().add(frame);
    	time.playFromStart(); 
    	secondsQ2 = startTimeQ2;
    }
    //............ Question 2: Suma .........
    
    @FXML
    public void bttnAnswer42(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	showThirdQuestion();
    	
    }

    @FXML
    public void bttnAnswer45(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	showThirdQuestion();
    }

    @FXML
    public void bttnAnswer47(ActionEvent event) throws IOException {
    	int score = player.getScore()+10;
    	player.setScore(score);
    	time.stop();
    	showThirdQuestion();
    }

    @FXML
    public void bttnAnswer57(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	showThirdQuestion();
    }
    
    public void showThirdQuestion() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Question3.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.show();
		lblScoreQ3.setText(String.valueOf(player.getScore()));
		doTimeQ3(lblTimerQ3);
    }
    
    
    private void doTimeQ3(Label label) {
    	time = new Timeline();
    	time.setCycleCount(Timeline.INDEFINITE);
    	if(time!=null) {
    		time.stop();
    	}
    	KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
    		
    		@Override
    		public void handle(ActionEvent event){
    			secondsQ3--;
    			label.setText(secondsQ3.toString());
    			if(secondsQ3<=0) {
    				time.stop();
    				try {
						showFourthQuestion();
					} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    		}
    	});
    	time.getKeyFrames().add(frame);
    	time.playFromStart(); 
    	secondsQ3 = startTimeQ3;
    }
    
    public void showFourthQuestion() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Question4.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.show();
		lblScoreQ4.setText(String.valueOf(player.getScore()));
		doTimeQ4(lblTimerQ4);
    }
    
    //.............. Question 3: Resta .........
    
    @FXML
    public void bttnAnswer58(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	showFourthQuestion();
    	
    }

    @FXML
    public void bttnAnswer68(ActionEvent event) throws IOException {
    	int score = player.getScore()+10;
    	player.setScore(score);
    	time.stop();
    	showFourthQuestion();
    	
    }

    @FXML
    public void bttnAnswer78(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	showFourthQuestion();

    }

    @FXML
    public void bttnAnswer88(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	showFourthQuestion();
    }
    
    
    private void doTimeQ4(Label label) {
    	time = new Timeline();
    	time.setCycleCount(Timeline.INDEFINITE);
    	
    	if(time!=null) {
    		time.stop();
    	}
    	
    	KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
    		
    		@Override
    		public void handle(ActionEvent event){
    			secondsQ4--;
    			label.setText(secondsQ4.toString());
    			if(secondsQ4<=0) {
    				time.stop();
    				try {
						showGameScore();
					} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    		}
    	});
    	time.getKeyFrames().add(frame);
    	time.playFromStart();
    	secondsQ4 = startTimeQ4;
    }

    //............. Question 4: Division .........
    
	@FXML
	public void bttnAnswer25(ActionEvent event) throws IOException {
		int score = player.getScore() - 10;
		player.setScore(score);
		time.stop();
		showGameScore();
	}

    @FXML
    public void bttnAnswer30(ActionEvent event) throws IOException {
    	int score = player.getScore()+10;
    	player.setScore(score);
    	time.stop();
    	showGameScore();
    }

    @FXML
    public void bttnAnswer35(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	showGameScore();
    }

    @FXML
    public void bttnAnswer40(ActionEvent event) throws IOException {
    	int score = player.getScore()-10;
    	player.setScore(score);
    	time.stop();
    	showGameScore();
    }
    
    public void showGameScore() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameScore.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.show();
		lblFinalScore.setText(String.valueOf(player.getScore()));
		mathChallenge.addScore(player);
    }
    
    
    //...................... GAME_SCORE .......................
    
   
    @FXML
    public void toScoreboardWindow(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scoreboard.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.show();
		
		lblPodiumName1.setText(max1(mathChallenge.getRoot()).getName());
		lblPodiumScore1.setText(String.valueOf(max1(mathChallenge.getRoot()).getScore()));
		
		
		if(mathChallenge.getRoot().getLeft()!=null || mathChallenge.getRoot().getRight()!=null) {
			lblPodiumName2.setText( max1(mathChallenge.getRoot()).getUp().getName() );
			lblPodiumScore2.setText( String.valueOf(max1(mathChallenge.getRoot()).getUp().getScore()) );
		}
		
		try {
			if(max1(mathChallenge.getRoot()).getUp().getLeft()!=null) {
				lblPodiumName3.setText( max1(mathChallenge.getRoot()).getUp().getLeft().getName() );
				lblPodiumScore3.setText( String.valueOf(max1(mathChallenge.getRoot()).getUp().getLeft().getScore()) );
			}else {
				lblPodiumName3.setText(max1(mathChallenge.getRoot()).getUp().getUp().getName());
				lblPodiumScore3.setText( String.valueOf(max1(mathChallenge.getRoot()).getUp().getUp().getScore()) );
			}
		}catch(NullPointerException ex) {
		}
		
    }
    
    
    public Player max1(Player current) {
		if(current.getRight()==null) {
			return current;
		}else {
			return max1(current.getRight());
		}
	}
    
    public Player searchPlayerRecursive(Player current, Player newPlayer) {
		if(current==null) {
			return null;
		}else if(current.getScore() == newPlayer.getScore()) {
			return newPlayer;
		}else if(newPlayer.getScore() > current.getScore()) {
			return searchPlayerRecursive(current.getRight(), newPlayer).getUp();
		}else {
			return searchPlayerRecursive(current.getLeft(), newPlayer).getUp();
		}
	}
    
    /*
    private Car searchCarRecursive(Car current, double price) {
		if(current==null) {
			return null;
		}else if(current.getPrice() == price) {
			return current;
		}else if(price > current.getPrice()) {
			return searchCarRecursive(current.getRight(), price);
		}else {
			return searchCarRecursive(current.getLeft(), price);
		}
	}
    */
    /*
    public static void printTreeInOrder() {
		if(carSeller.getRoot()==null) {
			System.out.println("The tree is empty");
		}else {
			printTreeInOrder(carSeller.getRoot());
		}
	}

	private static void printTreeInOrder(Car current) {
		if (current != null) {
			printTreeInOrder(current.getRight());
			System.out.println();
			System.out.println(current.toString());
			printTreeInOrder(current.getLeft());
		}
	}
    */
    
    //...................... SCOREBOARD...................
    
    
    @FXML
    public void exitTheApp(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    public void toRemoveScoreWindow(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveScore.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.show();
    }

    @FXML
    public void toSearchScoreWindow(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchScore.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.show();
		initializeComboBox();
    }

    @FXML
    public void toWelcomeWindow(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.show();
    }
    
    
    //................. SEARCH_SCORE................
    

    @FXML
    public void returnToScoreboardWindow(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scoreboard.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.show();
    }

    @FXML
    public void searchScore(ActionEvent event) {
    	String message = "";
		if (cmbxPlayers.getSelectionModel().getSelectedItem().equals("") == false) {
			Player playerx = cmbxPlayers.getSelectionModel().getSelectedItem();
			int scorex = mathChallenge.searchScore(playerx.getScore()).getScore();
			lblSearchedScore.setText( String.valueOf(scorex) );
		} else {
			message = "Please, select a person to see the score.";
			errorAlert(message);
		}

    }
    
    public void initializeComboBox() {
		ObservableList<Player> observableList = FXCollections.observableArrayList(players);
		cmbxPlayers.setItems(observableList);
	}
    
    //................. REMOVE_SCORE ...............
    
    
    @FXML
    public void removeScore(ActionEvent event) {
    	
    }

    @FXML
    public void returnToScoreboardWindow2(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scoreboard.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.show();
    }
    
    
    
    
    public void informationAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Math Challenge");
		alert.setHeaderText("Information");
		alert.setContentText(message);
		alert.show();
	}
    
    public void errorAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Math Challenge");
		alert.setHeaderText("Error");
		alert.setContentText(message);
		alert.show();
	}
}
