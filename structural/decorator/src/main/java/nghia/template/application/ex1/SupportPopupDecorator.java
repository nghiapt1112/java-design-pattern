package nghia.command.application.ex1;

public class SupportPopupDecorator extends AbstractColumDecorator {
    public SupportPopupDecorator(Report report) {
        super(report);
    }

    public String getFirstColumnData() {
        return addPopup (super.getFirstColumnData()) ;
    }

    private String addPopup(String data){
        return data  + " - support popup - ";
    }
}
