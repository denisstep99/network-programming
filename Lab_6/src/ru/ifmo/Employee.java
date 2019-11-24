package ru.ifmo;

public class Employee {
    private String style;
    private String empNo;
    private String empName;

    public Employee() { }

    public String getStyle() {
        return style;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
