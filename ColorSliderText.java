import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorSliderText extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create Text object to display
        Text text = new Text("JavaFX Color Slider");
        text.setFont(Font.font(24));

        // Create Labels for sliders
        Label redLabel = new Label("Red:");
        Label greenLabel = new Label("Green:");
        Label blueLabel = new Label("Blue:");
        Label opacityLabel = new Label("Opacity:");

        // Create Sliders
        Slider redSlider = createColorSlider(0, 255, 0);
        Slider greenSlider = createColorSlider(0, 255, 0);
        Slider blueSlider = createColorSlider(0, 255, 0);
        Slider opacitySlider = createOpacitySlider();

        // Bind color and opacity properties of the text to the slider values
        text.fillProperty().bind(
                javafx.beans.binding.Bindings.createObjectBinding(
                        () -> Color.rgb(
                                (int) redSlider.getValue(),
                                (int) greenSlider.getValue(),
                                (int) blueSlider.getValue(),
                                opacitySlider.getValue()
                        ),
                        redSlider.valueProperty(),
                        greenSlider.valueProperty(),
                        blueSlider.valueProperty(),
                        opacitySlider.valueProperty()
                )
        );

        // Create a GridPane to layout components
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Add components to the grid pane
        gridPane.add(text, 0, 0, 2, 1);
        gridPane.add(redLabel, 0, 1);
        gridPane.add(redSlider, 1, 1);
        gridPane.add(greenLabel, 0, 2);
        gridPane.add(greenSlider, 1, 2);
        gridPane.add(blueLabel, 0, 3);
        gridPane.add(blueSlider, 1, 3);
        gridPane.add(opacityLabel, 0, 4);
        gridPane.add(opacitySlider, 1, 4);

        // Create the scene and set it in the stage
        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setTitle("Color Slider Text");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create a color slider
    private Slider createColorSlider(int min, int max, int initialValue) {
        Slider slider = new Slider(min, max, initialValue);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(50);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);
        return slider;
    }

    // Method to create an opacity slider
    private Slider createOpacitySlider() {
        Slider slider = new Slider(0, 1, 1);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(0.2);
        slider.setMinorTickCount(4);
        slider.setBlockIncrement(0.1);
        return slider;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
