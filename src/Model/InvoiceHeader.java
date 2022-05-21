package Model;

import java.lang.reflect.Array;
import java.util.Date;

public class InvoiceHeader {
    public int InvoiceNumber;
    public String InvoiceDate;
    public String CustomerName;
    public int numbersOfInvoiceLines;
    public float totalInvoice;

public InvoiceHeader(int invoiceNumber,String invoiceDate,String customerName){

    this.CustomerName=customerName;
    this.InvoiceDate=invoiceDate;
    this.InvoiceNumber=invoiceNumber;
}

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setInvoiceDate(String invoiceDate) {
        InvoiceDate = invoiceDate;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        InvoiceNumber = invoiceNumber;
    }

    public void setNumbersOfInvoiceLines(int numbersOfInvoiceLines) {
        this.numbersOfInvoiceLines = numbersOfInvoiceLines;
    }

    public void setTotalInvoice(float totalInvoice) {
        this.totalInvoice = totalInvoice;
    }

    public String getInvoiceDate() {
        return InvoiceDate;
    }

    public int getInvoiceNumber() {
        return InvoiceNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public int getNumbersOfInvoiceLines() {
        return numbersOfInvoiceLines;
    }

    public float getTotalInvoice() {
        return totalInvoice;
    }

    public Object[] getArray(){
        int arrlength = 4;
        Object[] outputArray = new Object[arrlength];
        outputArray[0]=InvoiceNumber;
        outputArray[1]=InvoiceDate;
        outputArray[2]=CustomerName;
        outputArray[3]=totalInvoice;
        return outputArray;
    }
}
