package nghia.decorator.application.ex1;

public abstract class AbstractColumDecorator implements Report {
    private Report decoratedReport;

    public AbstractColumDecorator(Report report) {
        this.decoratedReport = report;
    }

    public String getFirstColumnData() {
        return decoratedReport.getFirstColumnData();
    }

    @Override
    public Object[][] getReportData(String reportId) {
        return decoratedReport.getReportData(reportId);
    }
}
