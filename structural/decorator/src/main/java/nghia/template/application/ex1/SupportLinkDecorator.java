package nghia.command.application.ex1;

public class SupportLinkDecorator extends AbstractColumDecorator {


    public SupportLinkDecorator(Report report) {
        super(report);
    }

    public String getFirstColumnData() {
        return addMoreInfo (super.getFirstColumnData()) ;
    }

    private String addMoreInfo(String data){
        return data  + " - support link - ";
    }
}
