package samples;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.utils.ExtentUtil;

public class ExtendtReports {
    protected ExtentReports reports;
    protected ExtentTest logger;
    public ExtendtReports(){
        reports = new ExtentReports("C:\\Users\\Toshiba\\Documents\\Eclipse\\com.rousesrvices\\src\\test\\Report.html");
    }
}
