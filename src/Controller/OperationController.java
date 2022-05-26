package Controller;

import Model.InvoiceHeader;
import Model.InvoiceItems;
import View.FormDesign;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OperationController {
    private String mainFilePath;
    private DefaultTableModel dtm;
    private DefaultTableModel detailsModelTable;
    private String detailsFilePath;
    private JTable invoiceTable;
    private JTable invoiceItems;
    List<InvoiceHeader>
            myList = new ArrayList<InvoiceHeader>();
    List<InvoiceItems> listDetails = new ArrayList<InvoiceItems>();

    public void openMainFile(String mainFilePath,DefaultTableModel dtm){

        FileInputStream fis = null;
        try {
            try {
                fis = new FileInputStream(mainFilePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            InputStreamReader ispr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(ispr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                InvoiceHeader invoice = new InvoiceHeader(Integer.parseInt(s[0]), s[1],s[2]);
                myList.add(invoice);
            }

            double counter = 0;
            for (int i = 0; i < myList.toArray().length; i++) {
                InvoiceHeader tableRow = myList.get(i);

                counter= (double)
                        listDetails.stream().
                                filter(listRow -> listRow.invoiceNumber == tableRow.InvoiceNumber)
                                .map((list)->list.numberOfItemsPurchased*list.itemPrice).mapToDouble(Float::doubleValue).sum();

                tableRow.totalInvoice =(float) counter;
                dtm.addRow(tableRow.getArray());
            }



            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    public void openDetailedFile(String detailsFilePath){
        File fileDetails = new File(detailsFilePath);
        String pathDetails = fileDetails.getAbsolutePath();

//      String pathDetails = file.getSelectedFile().getPath();
        FileInputStream fisDetails = null;
        try {
            try {
                fisDetails = new FileInputStream(pathDetails);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            InputStreamReader ispr = new InputStreamReader(fisDetails);
            BufferedReader brDetails = new BufferedReader(ispr);
            String line;

            while ((line = brDetails.readLine()) != null) {
                String[] s = line.split(",");
                InvoiceItems invoiceLines = new InvoiceItems(Integer.parseInt(s[0]), s[1],Float.parseFloat(s[2]),Integer.parseInt(s[3]));
                listDetails.add(invoiceLines);


            }


            brDetails.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fisDetails.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    public void deleteRow(DefaultTableModel detailsModelTable,JTable invoiceTable,DefaultTableModel dtm) {
        int action = JOptionPane.showConfirmDialog(null, "Do you want Really to delete", "Delete", JOptionPane.CANCEL_OPTION);
        if (action == 0) {
            int rowId;
            int selectedRow;
            selectedRow = invoiceTable.getSelectedRow();
            rowId = (int) invoiceTable.getValueAt(selectedRow, 0);
            if (selectedRow != -1) {
                dtm.removeRow(selectedRow);
            }
            listDetails = listDetails.stream().filter(listRow -> listRow.invoiceNumber != rowId).toList();
            myList = myList.stream().filter(myrow -> myrow.InvoiceNumber != rowId).toList();
            detailsModelTable.setNumRows(0);

        }
    }


    public void savefile(String mainFilePath) {

        try {

            File file = new File(mainFilePath);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < myList.size(); i++) {
                InvoiceHeader listRow=myList.get(i);
                bw.write(listRow.InvoiceNumber + "," + listRow.InvoiceDate + "," + listRow.CustomerName);
                bw.newLine();
            }
            saveDetailsFile(mainFilePath);
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDetailsFile(String path) {

        try {
            Path parentPath = Paths.get(path);
            String pathDetails = parentPath.getParent() + "/InvoiceLine.csv";
            File file = new File(pathDetails);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < listDetails.size(); i++) {
                InvoiceItems listDetailsRow=listDetails.get(i);
                bw.write(listDetailsRow.invoiceNumber+ "," + listDetailsRow.itemName + "," + listDetailsRow.itemPrice + "," + listDetailsRow.numberOfItemsPurchased);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public int myListLength(){

       return myList.toArray().length;


}


    public InvoiceHeader myListValues(int i){

        return myList.get(i);


    }

    public void addToMyListdata(InvoiceHeader data){

        myList.add(data);


    }

    public InvoiceItems myInvoiceItems(int i){

        return listDetails.get(i);


    }

    public int myInvoiceListItemLength(){

        return listDetails.toArray().length;


    }


//    public void deleteDetails(DefaultTableModel detailsModelTable,JTable invoiceItems) {
//        int action = JOptionPane.showConfirmDialog(null,"Do you want Really to delete","Delete",JOptionPane.CANCEL_OPTION);
//        if(action==0) {
//            int rowId;
//            int selectedRow;
//            selectedRow = invoiceItems.getSelectedRow();
//            rowId = (int) invoiceItems.getValueAt(selectedRow, 0);
//            if (selectedRow != -1) {
//                detailsModelTable.removeRow(selectedRow);
//            }
//        }
//   //     listDetails = listDetails.stream().filter(listRow -> listRow.invoiceNumber != rowId).toList();
////        myList = myList.stream().filter(myrow -> myrow.InvoiceNumber != rowId).toList();
////        detailsModelTable.setNumRows(0);
//
//    }

}

