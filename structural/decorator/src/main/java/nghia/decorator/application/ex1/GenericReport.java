package nghia.decorator.application.ex1;

public class GenericReport implements Report {
    @Override
    public Object[][] getReportData(String reportId) {
        return null;
    }

    @Override
    public String getFirstColumnData() {
        return "Support data";
    }
}
