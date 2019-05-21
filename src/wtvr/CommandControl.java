package wtvr;

public class CommandControl {
    Command slot;
    public void setCommand(Command command){
        command=slot;
    }
    public void buttonWasPressed(){

        slot.excute();
    }
}
