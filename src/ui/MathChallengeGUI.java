package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MathChallengeGUI {
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
    
	//***************************** METHODS ***********************
	
	// ............. WELCOME ...............

    @FXML
    public void developerInfo(ActionEvent event) {

    }

    @FXML
    public void play(ActionEvent event) {

    }
    
    //............ Question 1: Multiplicación ..........
    
    @FXML
    public void bttnAnswer74(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer84(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer86(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer92(ActionEvent event) {

    }
    
    //............ Question 2: Suma .........
    
    @FXML
    public void bttnAnswer42(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer45(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer47(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer57(ActionEvent event) {

    }
    
    //.............. Question 3: Resta .........
    
    @FXML
    public void bttnAnswer58(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer68(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer78(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer88(ActionEvent event) {

    }
    
    //............. Question 4: Division .........
    
    @FXML
    public void bttnAnswer25(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer30(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer35(ActionEvent event) {

    }

    @FXML
    public void bttnAnswer40(ActionEvent event) {

    }
    
}
