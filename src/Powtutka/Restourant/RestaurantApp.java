package Powtutka.Restourant;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class RestaurantApp extends Application {

    private Order order = new Order();
    private ListView<String> orderListView = new ListView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Система заказов в ресторане");

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // Создаем список доступных блюд
        ChoiceBox<String> dishChoiceBox = new ChoiceBox<>();
        dishChoiceBox.getItems().addAll("Пепперони", "Цезарь", "Кола");

        // Создаем поле для ввода цены
        TextField priceTextField = new TextField();
        priceTextField.setPromptText("Цена");

        // Кнопка для добавления блюда в заказ
        Button addButton = new Button("Добавить в заказ");
        addButton.setOnAction(e -> {
            String selectedDish = dishChoiceBox.getValue();
            String priceText = priceTextField.getText();

            if (selectedDish != null && !priceText.isEmpty()) {
                double price = Double.parseDouble(priceText);
                Dish dish = new Dish(selectedDish, price);
                order.addDish(dish);
                updateOrderListView();
                dishChoiceBox.setValue(null);
                priceTextField.clear();
            }
        });

        // Создаем список заказанных блюд
        orderListView.setPrefHeight(200);

        // Кнопка для расчета общей стоимости заказа
        Button calculateButton = new Button("Рассчитать стоимость");
        calculateButton.setOnAction(e -> {
            double total = order.calculateTotalPrice();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Общая стоимость заказа");
            alert.setHeaderText(null);
            alert.setContentText("Общая стоимость заказа: " + total + "$");
            alert.showAndWait();
        });

        root.getChildren().addAll(dishChoiceBox, priceTextField, addButton, orderListView, calculateButton);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateOrderListView() {
        orderListView.getItems().clear();
        for (Dish dish : order.getDishes()) {
            orderListView.getItems().add(dish.getName() + " - " + dish.getPrice() + "$");
        }
    }
}
