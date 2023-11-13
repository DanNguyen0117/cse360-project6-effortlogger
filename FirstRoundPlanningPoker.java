package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class FirstRoundPlanningPoker {
	private boolean didInit = false;
	private HistoricalProjects hp = new HistoricalProjects();
	@FXML 
	private ChoiceBox<String> projectChoiceBox;
	@FXML
	private TextField description;
	@FXML
	private ListView historicalItemList;
	@FXML
	private TextField storyPoints;
	@FXML
	private Button removeHistoricalItemBtn;
	@FXML
	private Button generateBtn;
	@FXML
	private Button nextRoundBtn;
	@FXML
	private Button importBtn;
	
	String[] projects = {"Project 1", "Project 2"};
	String currentItem;
	
	public void importPreviousProjects() {
		if(!didInit) {
			//initialize
			didInit = true;
			HashMap<String, List<String>> dict = new HashMap<>();
			
			dict.put("Project 1", new ArrayList<>());
			dict.put("Project 2", new ArrayList<>());
			
			dict.get("Project 1").add("Item 1");
			dict.get("Project 1").add("Item 2");
			dict.get("Project 1").add("Item 3");
			dict.get("Project 1").add("Item 4");
			
			dict.get("Project 2").add("Item 11");
			dict.get("Project 2").add("Item 12");
			dict.get("Project 2").add("Item 13");
			dict.get("Project 2").add("Item 14");
			
			hp.setHistoricalProjects(dict);
			
			projectChoiceBox.getItems().addAll(projects);
			projectChoiceBox.setOnAction(this::selectedProject);
			
			
			description.setText("This project talks about the current state of things.");
			System.out.println("import successful");
		}
	}
	
	public void selectedProject(ActionEvent event) {
		String projectName = projectChoiceBox.getValue();
		HashMap<String, List<String>> dict = hp.getHistoricalProjects();
		
		historicalItemList.getItems().clear();
		historicalItemList.getItems().addAll(dict.get(projectName));
		historicalItemList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> Observable, String oldVal, String newVal) {
				currentItem = (String) historicalItemList.getSelectionModel().getSelectedItem();
			}
		});
	}
	
	public void removeItem(ActionEvent event) {
		if(!historicalItemList.getItems().isEmpty()) {
			int selectedID = historicalItemList.getSelectionModel().getSelectedIndex();
			historicalItemList.getItems().remove(selectedID);
			System.out.println("removed: " + selectedID);
		}
	}
	
	public void generateStoryPoints() {
		int totalPoints = 0;
		if(historicalItemList.getItems().isEmpty()) {
			storyPoints.setText("0");
		} else {
			int totalItems = historicalItemList.getItems().size();
			totalPoints = 10 * totalItems;
			storyPoints.setText(Integer.toString(totalPoints));
		}
	}
	
	public void nextRoundBtnPushed() {
		System.out.println("Next Round! Current Story Points: " + storyPoints.getText());
	}
	
	
}
