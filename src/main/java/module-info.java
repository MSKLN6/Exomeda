module be.fiiw.exomeda {
    requires javafx.controls;
    requires javafx.fxml;

    opens be.fiiw.exomeda to javafx.fxml;
    exports be.fiiw.exomeda;
}
