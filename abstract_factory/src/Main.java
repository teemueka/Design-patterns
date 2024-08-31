public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new AFactory();
        Button newbutton = factoryA.createButton("originalButtonA");
        Checkbox newCheckbox = factoryA.createCheckbox("originalCheckboxA");
        TextField newTextField = factoryA.createTextField("originalTextFieldA");

        newbutton.display();
        newCheckbox.display();
        newTextField.display();

        System.out.println();
        newbutton.setText("changed button A");
        newCheckbox.setText("changed checkbox A");
        newTextField.setText("changed TextField A");

        newbutton.display();
        newCheckbox.display();
        newTextField.display();
        System.out.println();

        UIFactory factoryB = new BFactory();
        Button newbuttonB = factoryB.createButton("originalButtonB");
        Checkbox newCheckboxB = factoryB.createCheckbox("originalCheckboxB");
        TextField newTextFieldB = factoryB.createTextField("originalTextFieldB");

        newbuttonB.display();
        newCheckboxB.display();
        newTextFieldB.display();
        System.out.println();

        newbuttonB.setText("changed button B");
        newCheckboxB.setText("changed checkbox B");
        newTextFieldB.setText("changed TextField B");

        newbuttonB.display();
        newCheckboxB.display();
        newTextFieldB.display();


    }
}