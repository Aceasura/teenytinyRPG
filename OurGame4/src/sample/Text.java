package sample;

import javafx.scene.control.Label;

public class Text {

    private String text;

    public Text(String t) {
        text = t;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void DisplayText(Label label){
        label.setText(getText());
        System.out.println(this.text);
    }
}
