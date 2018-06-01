package help;

public class TestCaseParameters {
    private String keyWord;
    private String object;
    private String parameter;
    private String actualResult;
    private String expectedResult;
    public TestCaseParameters(String keyWord, String object, String parameter, String actualResult, String expectedResult){
        this.keyWord = keyWord;
        this.object = object;
        this.parameter = parameter;
        this.actualResult = actualResult;
        this.expectedResult = expectedResult;
    }

    public String getKeyWord(){
        return keyWord;
    }

    public String getObject() {
        return object;
    }
    public String getParameter(){
        return parameter;
    }

    public String getActualResult() {
        return actualResult;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    /*public String stepsReader(Object[][] testCaseArray) {
        for (int i = 0; i <= testCaseArray.length; i++){
            for (int j = 0; j <= testCaseArray[i].length; j++){
                setKeyWord(testCaseArray[i][j].toString());
            }
        }
        return null;
    }*/
}
