package Controllers;

import Entities.DossierReclamation;
import Service.ServiceDossierReclamation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DossierReclamationsCrudController {
    @FXML
    private TableView<DossierReclamation> tableView;

    private final ServiceDossierReclamation serviceDossierReclamation = new ServiceDossierReclamation();
    @FXML
    public void initialize() {
        initializeTableColumns();
        updateDossierReclamationList();
    }

    private void updateDossierReclamationList() {
        List<DossierReclamation> dossierReclamations = serviceDossierReclamation.getAll();

        tableView.getItems().clear();

        tableView.getItems().addAll(dossierReclamations);

    }

    private void initializeTableColumns() {
        tableView.getColumns().clear();

        TableColumn<DossierReclamation, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<DossierReclamation, String> serieVehicule = new TableColumn<>("serieVehicule");
        serieVehicule.setCellValueFactory(new PropertyValueFactory<>("serieVehicule"));

        TableColumn<DossierReclamation, Void> actionColumn = new TableColumn<>("Action");
        actionColumn.setCellFactory(getButtonCellFactory());
        TableColumn<DossierReclamation, Void> imageCarteGrise = new TableColumn<>("imageCarteGrise");
        imageCarteGrise.setCellFactory(column -> {
            return new TableCell<DossierReclamation, Void>() {
                private final ImageView imageView = new ImageView();
                private final double imageSize = 50; // Adjust the size of the image as needed

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        DossierReclamation dossierReclamation = getTableRow().getItem();
                        if (dossierReclamation != null && dossierReclamation.getImageCarteGrise() != null) {
                            try {
                                System.out.println("https://localhost:8000/images/"+dossierReclamation.getImageCarteGrise());
                                String imageUrl = "http://localhost:8000/images/"+dossierReclamation.getImageCarteGrise();
                                System.out.println(imageUrl);
                                Image image = new Image(imageUrl);
                                imageView.setImage(image);
                                imageView.setFitWidth(imageSize);
                                imageView.setFitHeight(imageSize);
                                setGraphic(imageView);
                            } catch (Exception e) {
                                // Handle any exceptions that may occur while loading the image
                                e.printStackTrace();
                            }
                        } else {
                            setGraphic(null);
                        }
                    }
                }
            };
        });
        TableColumn<DossierReclamation, Void> imageRectoCIN = new TableColumn<>("imageRectoCIN");
        imageRectoCIN.setCellFactory(column -> {
            return new TableCell<DossierReclamation, Void>() {
                private final ImageView imageView = new ImageView();
                private final double imageSize = 50; // Adjust the size of the image as needed

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        DossierReclamation dossierReclamation = getTableRow().getItem();
                        if (dossierReclamation != null && dossierReclamation.getImageRectoCin() != null) {
                            try {
                                System.out.println("https://localhost:8000/images/"+dossierReclamation.getImageRectoCin());
                                String imageUrl = "http://localhost:8000/images/"+dossierReclamation.getImageRectoCin();
                                System.out.println(imageUrl);
                                Image image = new Image(imageUrl);
                                imageView.setImage(image);
                                imageView.setFitWidth(imageSize);
                                imageView.setFitHeight(imageSize);
                                setGraphic(imageView);
                            } catch (Exception e) {
                                // Handle any exceptions that may occur while loading the image
                                e.printStackTrace();
                            }
                        } else {
                            setGraphic(null);
                        }
                    }
                }
            };
        });
        TableColumn<DossierReclamation, Void> imageVersoCIN = new TableColumn<>("imageVersoCIN");
        imageVersoCIN.setCellFactory(column -> {
            return new TableCell<DossierReclamation, Void>() {
                private final ImageView imageView = new ImageView();
                private final double imageSize = 50; // Adjust the size of the image as needed

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        DossierReclamation dossierReclamation = getTableRow().getItem();
                        if (dossierReclamation != null && dossierReclamation.getImageVersoCin() != null) {
                            try {
                                System.out.println("https://localhost:8000/images/"+dossierReclamation.getImageVersoCin());
                                String imageUrl = "http://localhost:8000/images/"+dossierReclamation.getImageVersoCin();
                                System.out.println(imageUrl);
                                Image image = new Image(imageUrl);
                                imageView.setImage(image);
                                imageView.setFitWidth(imageSize);
                                imageView.setFitHeight(imageSize);
                                setGraphic(imageView);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            setGraphic(null);
                        }
                    }
                }
            };
        });
        // imageColumn.setCellFactory(getImageCellFactory());
        System.out.println("Columns added");
        tableView.getColumns().addAll(idColumn, serieVehicule,imageCarteGrise,imageRectoCIN,imageVersoCIN,actionColumn);
    }

    public void goToNavigate(ActionEvent event) {
        RouterController.navigate("/fxml/AdminDashboard.fxml");
    }

    public void searchquery(KeyEvent keyEvent) {
    }

    public void gotoAjouter(ActionEvent event) {
        RouterController.navigate("/fxml/AddDossierReclamation.fxml");
    }
    private Callback<TableColumn<DossierReclamation, Void>, TableCell<DossierReclamation, Void>> getButtonCellFactory() {
        return new Callback<TableColumn<DossierReclamation, Void>, TableCell<DossierReclamation, Void>>() {
            @Override
            public TableCell<DossierReclamation, Void> call(final TableColumn<DossierReclamation, Void> param) {
                final TableCell<DossierReclamation, Void> cell = new TableCell<DossierReclamation, Void>() {
                    private final Button modifyButton = new Button();
                    private final Button deleteButton = new Button();
                    private final Button claimButton = new Button();

                    {
                        Image modifyImage = new Image(getClass().getResourceAsStream("../assets/modify.png"));
                        ImageView modifyIcon = new ImageView(modifyImage);
                        modifyIcon.setFitWidth(20);
                        modifyIcon.setFitHeight(20);
                        modifyButton.setGraphic(modifyIcon);

                        modifyButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-background-radius: 5px; -fx-padding: 5px 10px;");

                        deleteButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-background-radius: 5px; -fx-padding: 5px 10px;");

                        Image deleteImage = new Image(getClass().getResourceAsStream("../assets/delete.png"));
                        ImageView deleteIcon = new ImageView(deleteImage);
                        deleteIcon.setFitWidth(16);
                        deleteIcon.setFitHeight(16);
                        deleteButton.setGraphic(deleteIcon);

                        modifyButton.setOnAction((ActionEvent event) -> {
                            DossierReclamation dossierReclamation = getTableView().getItems().get(getIndex());
                        });

                        deleteButton.setOnAction((ActionEvent event) -> {
                            DossierReclamation dossierReclamation = getTableView().getItems().get(getIndex());
                        });
                        Image claimImage = new Image(getClass().getResourceAsStream("../assets/claim.png"));
                        ImageView claimIcon = new ImageView(claimImage);
                        claimIcon.setFitWidth(20);
                        claimIcon.setFitHeight(20);
                        claimButton.setGraphic(claimIcon);

                        claimIcon.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-background-radius: 5px; -fx-padding: 5px 10px;");

                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox buttons = new HBox(5);
                            Image claimImage = new Image(getClass().getResourceAsStream("../assets/claim.png"));
                            ImageView claimIcon = new ImageView(claimImage);
                            claimIcon.setFitWidth(20);
                            claimIcon.setFitHeight(20);
                            claimButton.setGraphic(claimIcon);

                            claimIcon.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-background-radius: 5px; -fx-padding: 5px 10px;");

                            buttons.getChildren().addAll(modifyButton, deleteButton,claimButton);

                            modifyButton.setFocusTraversable(false);
                            deleteButton.setFocusTraversable(false);

                            modifyButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-background-radius: 5px; -fx-padding: 5px 10px;");
                            deleteButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-background-radius: 5px; -fx-padding: 5px 10px;");

                            Image modifyImage = new Image(getClass().getResourceAsStream("../assets/modify.png"));
                            ImageView modifyIcon = new ImageView(modifyImage);
                            modifyIcon.setFitWidth(20);
                            modifyIcon.setFitHeight(20);
                            modifyButton.setGraphic(modifyIcon);
                            Image deleteImage = new Image(getClass().getResourceAsStream("../assets/delete.png"));
                            ImageView deleteIcon = new ImageView(deleteImage);
                            deleteIcon.setFitWidth(20);
                            deleteIcon.setFitHeight(20);
                            deleteButton.setGraphic(deleteIcon);
                            modifyButton.setOnAction((ActionEvent event) -> {
                                DossierReclamation dossierReclamation = getTableView().getSelectionModel().getSelectedItem();
                                System.out.println(dossierReclamation);
                                if (dossierReclamation != null) {
                                    System.out.println("SETTING ID");
                                    System.out.println(dossierReclamation.getId());

                                    // Assuming that the image file is stored as a String path in the DossierReclamation object
                                    String selectedImageFile = dossierReclamation.getImageCarteGrise();
                                    String selectedImageFile2 = dossierReclamation.getImageRectoCin();
                                    String selectedImageFile3 = dossierReclamation.getImageVersoCin();// Change this line according to your object structure

                                    // Now you can use the selected image file path as needed
                                    System.out.println("Selected image file: " + selectedImageFile);

                                    System.out.println("Selected image file: " + selectedImageFile2);

                                    System.out.println("Selected image file: " + selectedImageFile3);
                                    EditDossierReclamationController.dossierReclamation_static = dossierReclamation;
                                    RouterController.navigate("/fxml/EditDossierReclamation.fxml");
                                }

                            });


                            deleteButton.setOnAction((ActionEvent event) -> {
                                DossierReclamation dossierReclamation = getTableView().getItems().get(getIndex());

                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Confirmation");
                                alert.setHeaderText("Supprimer Pack");
                                alert.setContentText("Vous etes sur tu veux supprimer cette Pack?");

                                Optional<ButtonType> result = alert.showAndWait();
                                if (result.isPresent() && result.get() == ButtonType.OK) {
                                    serviceDossierReclamation.delete(dossierReclamation.getId());
                                    initialize();

                                }
                            });
                            claimButton.setOnAction((ActionEvent event) ->
                            {
                                DossierReclamation dossierReclamation = getTableView().getItems().get(getIndex());
                                System.out.println("Claiming dossier reclamation with id: " + dossierReclamation.getId());
                                if(dossierReclamation.getReclamation()!=null)
                                {
                                    System.out.println("Claiming dossier reclamation with id: " + dossierReclamation.getId());
                                    EditReclamationsController.Dossierreclamation_static= dossierReclamation;
                                    System.out.println(dossierReclamation.getReclamation());
                                    RouterController.navigate("/fxml/EditReclamation.fxml");
                                }else {
                                    EditReclamationsController.Dossierreclamation_static= null;
                                    EditReclamationsController.Dossierreclamation_static_with_no_reclamation=dossierReclamation;
                                    System.out.println(dossierReclamation.getReclamation());
                                    RouterController.navigate("/fxml/EditReclamation.fxml");
                                }
                            });
                            setGraphic(buttons);
                        }
                    }
                };
                return cell;
            }
        };
    }

}
