package nghia.command.application.ex1;

public interface Report {
    public Object[][] getReportData(final String reportId);

    public String getFirstColumnData();
}
