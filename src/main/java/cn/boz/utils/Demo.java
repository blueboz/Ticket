package cn.boz.utils;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Demo extends Application {

    public static void main(String args[]){
        launch(args);
    }

    /**
     * start 方式是所有JavaFx应用程序的入口
     * java 将UI 定义为 Stage与 Scene
     * Stage是顶级容器
     * Scene是所有内容的容器
     * 下面的例子中创建了Scene 并且设置了其大小,并且使其可见
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        //stackPane类似于layout,StackPane是堆栈的方式
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
