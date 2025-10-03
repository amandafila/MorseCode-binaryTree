import TreeStructure.Node;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TreeDisplay extends Application {

    private static Node root;

    public static void setRoot(Node rootNode) {
        root = rootNode;
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        if (root != null) {
            drawTree(pane, root, 400, 50, 200);
        }

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Visualização da Árvore de Código Morse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawTree(Pane pane, Node node, double x, double y, double hGap) {
        if (node.getLeft() != null) {
            double childX = x - hGap;
            double childY = y + 50;
            pane.getChildren().add(new Line(x, y, childX, childY));
            drawTree(pane, node.getLeft(), childX, childY, hGap / 2);
        }

        if (node.getRight() != null) {
            double childX = x + hGap;
            double childY = y + 50;
            pane.getChildren().add(new Line(x, y, childX, childY));
            drawTree(pane, node.getRight(), childX, childY, hGap / 2);
        }

        Circle circle = new Circle(x, y, 15);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Text text = new Text(x - 4, y + 4, String.valueOf(node.getElement()));

        pane.getChildren().addAll(circle, text);
    }
}