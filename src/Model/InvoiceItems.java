package Model;

public class InvoiceItems {

    public int invoiceNumber;
    public String itemName;
    public float itemPrice;
    public int numberOfItemsPurchased;
    public float totalInvoice;
    public InvoiceItems(int invoiceNumber,String itemName,float itemPrice,int numberOfItemsPurchased){

        this.invoiceNumber=invoiceNumber;
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.numberOfItemsPurchased=numberOfItemsPurchased;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setNumberOfItemsPurchased(int numberOfItemsPurchased) {
        this.numberOfItemsPurchased = numberOfItemsPurchased;
    }

    public void setTotalInvoice(float totalInvoice) {
        this.totalInvoice = totalInvoice;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public int getNumberOfItemsPurchased() {
        return numberOfItemsPurchased;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public float getTotalInvoice() {
        return totalInvoice;
    }


    public Object[] getDetailed(){
        int arrlength = 5;
        Object[] outputArray = new Object[arrlength];
        outputArray[0]=invoiceNumber;
        outputArray[1]=itemName;
        outputArray[2]=itemPrice;
        outputArray[3]=numberOfItemsPurchased;
        outputArray[4]=totalInvoice;
        return outputArray;
    }

}
