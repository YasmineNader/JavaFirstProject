package View;

import Controller.OperationController;
import Model.InvoiceHeader;
import Model.InvoiceItems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.nio.file.Path;

public class FormDesign extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem loadFileItem;
    private JMenuItem SaveFileItem;
    private JTable invoiceTable;
    private DefaultTableModel dtm;
    private DefaultTableModel detailsModelTable;
    private JTable invoiceItems;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel customerPanel;
    private JPanel customerInvoiceTable;
    private JButton newInvoice;
    private JButton deleteInvoice;
    private JButton saveUpdate;
    private JButton cancel;
    private JTextField invoiceDate;
    private JTextField customerName;
    private JLabel invoiceSum;
    private JLabel invoiceNumber;
    private String mainFilePath;
    private String detailsFilePath;
    enum actions{
      save,
      update
    }
    actions action;
//    List<InvoiceHeader> myList = new ArrayList<InvoiceHeader>();
//    List<InvoiceItems> listDetails = new ArrayList<InvoiceItems>();
    private double[] x;
OperationController controller = new OperationController();
private void ClearTextData(){
    invoiceDate.setText("");
    customerName.setText("");
    invoiceSum.setText("");

}

public void setFormLayout(){

    mainPanel = new JPanel(new GridLayout(1, 2));
    leftPanel = new JPanel(new FlowLayout());
    rightPanel = new JPanel(new GridLayout(2, 1));
    customerPanel = new JPanel(new GridLayout(4, 2));
    customerInvoiceTable=new JPanel(new FlowLayout());
    rightPanel.add(customerPanel);




    mainPanel.add(leftPanel);
    mainPanel.add(rightPanel);

    //Menu

    menuBar = new JMenuBar();
    loadFileItem = new JMenuItem("Load File");
    loadFileItem.addActionListener(this);
    loadFileItem.setActionCommand("load");
    SaveFileItem = new JMenuItem("Save File");
    SaveFileItem.addActionListener(this);
    SaveFileItem.setActionCommand("save");

    fileMenu = new JMenu("File");
    fileMenu.add(loadFileItem);
    fileMenu.add(SaveFileItem);
    menuBar.add(fileMenu);
    setJMenuBar(menuBar);
    //Table


    invoiceTable = new JTable();
    leftPanel.add(new JScrollPane(invoiceTable));


    //Buttons
    newInvoice = new JButton("Create New Invoice");
    leftPanel.add(newInvoice);
    deleteInvoice = new JButton("Delete Invoice");
    leftPanel.add(deleteInvoice);


    JLabel invoiceLabel =new JLabel("Invoice Number");
    customerPanel.add(invoiceLabel);
    invoiceNumber = new JLabel();

    customerPanel.add((invoiceNumber));
    invoiceDate = new JTextField("");
    customerPanel.add(new JLabel("Invoice Date"));

    customerPanel.add(invoiceDate);

    customerName = new JTextField("");
    customerPanel.add(new JLabel("Customer Name"));

    customerPanel.add(customerName);

    customerPanel.add(new JLabel("Invoice Total"));
    invoiceSum = new JLabel();
    customerPanel.add(invoiceSum);

    rightPanel.add(customerPanel);

    invoiceItems = new JTable();
    customerInvoiceTable.add(new JScrollPane(invoiceItems));
    rightPanel.add(customerInvoiceTable);


    //Buttons
    saveUpdate = new JButton("saveUpdate");
    customerInvoiceTable.add(saveUpdate);

    cancel = new JButton("Cancel");
    customerInvoiceTable.add(cancel);
    add(mainPanel);
    //Form
//    setSize(1000, 600);
//    setLocation(0, 0);
    Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
    setMaximumSize(DimMax);

    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}
    public FormDesign() {

        super("Design Preview (New Form)");

        setFormLayout();


        dtm = new DefaultTableModel(0, 0);


        detailsModelTable = new DefaultTableModel(0, 0);
        // add header of the table
        String header[] = new String[]{"No.", "Date", "Customer", "Total"};
        String itemDetails[] = new String[]{"No.", "Item Name", "Item Price ", "count", "item Total"};
        // add header in table model
        dtm.setColumnIdentifiers(header);
        invoiceTable.setModel(dtm);

        detailsModelTable.setColumnIdentifiers(itemDetails);
        invoiceItems.setModel(detailsModelTable);

        invoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action = actions.update;
                int dataId;
                DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
                int selectedRow = invoiceTable.getSelectedRow();
                ClearTextData();
                dataId = (int)invoiceTable.getValueAt(selectedRow, 0);
                String invdate = (String) invoiceTable.getValueAt(selectedRow, 1);
                String name = (String) invoiceTable.getValueAt(selectedRow, 2);
                invoiceNumber.setText(Integer.toString(dataId));
                invoiceDate.setText(invdate);
                customerName.setText(name);

                System.out.println(dataId);


                detailsModelTable.setNumRows(0);
                int totalInvoice = 0;

                for (int i = 0; i < controller.myInvoiceListItemLength(); i++) {

                    if (dataId == controller.myInvoiceItems(i).invoiceNumber){
                        InvoiceItems tableRow = controller.myInvoiceItems(i);
                        float totalCount = tableRow.itemPrice * tableRow.numberOfItemsPurchased;
                        totalInvoice += totalCount;
                        tableRow.totalInvoice = totalCount;
                        detailsModelTable.addRow(tableRow.getDetailed());
                    }

                }
                invoiceSum.setText(Integer.toString(totalInvoice));

            }

        });





        newInvoice.addActionListener(this);
        newInvoice.setActionCommand("NewInvoice");
        deleteInvoice.addActionListener(this);
        deleteInvoice.setActionCommand("delete");



        //right panel
        //text boxes


        saveUpdate.addActionListener(this);
        saveUpdate.setActionCommand("saveUpdate");

        cancel.addActionListener(this);
        cancel.setActionCommand("cancel");





    }

    private void openFile() {
        JFileChooser file = new JFileChooser();
        int result = file.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            mainFilePath = file.getSelectedFile().getPath();
            Path parentPath = Paths.get(mainFilePath);
            detailsFilePath = parentPath.getParent() + "/InvoiceLine.csv";
            controller.openDetailedFile(detailsFilePath);
            controller.openMainFile(parentPath.toString(),dtm);


        }


    }




    public void cancelUpdate() {

         String dataId;
        int selectedRow = invoiceTable.getSelectedRow();
        ClearTextData();
        dataId = invoiceTable.getValueAt(selectedRow, 0).toString();
        String invdate = (String) invoiceTable.getValueAt(selectedRow, 1);
        String name = (String) invoiceTable.getValueAt(selectedRow, 2);
        invoiceNumber.setText(dataId);
        invoiceDate.setText(invdate);
        customerName.setText(name);


    }


    public void saveUpdate() {


    if(action==actions.save) {
        String id = invoiceNumber.getText();
        String date = invoiceDate.getText();
        String name = customerName.getText();
        InvoiceHeader data = new InvoiceHeader(Integer.parseInt(id), date, name);
        controller.addToMyListdata(data);
    }
    else if(action==actions.update) {

        for (int i = 0; i <controller.myListLength(); i++) {
            InvoiceHeader tableRow = controller.myListValues(i);
            if (tableRow.InvoiceNumber ==Integer.parseInt(invoiceNumber.getText())) {
                tableRow.InvoiceDate = invoiceDate.getText();
                tableRow.CustomerName = customerName.getText();
            }
        }
    }
        controller.savefile(mainFilePath);
        dtm.setNumRows(0);

        for (int i = 0; i <controller.myListLength(); i++) {
           InvoiceHeader tableRow = controller.myListValues(i);
            dtm.addRow(tableRow.getArray());
        }
        getTableData (invoiceItems);
        }


    public Object[][] getTableData (JTable table) {

        detailsModelTable.fireTableDataChanged();
        TableModel dtm = table.getModel();

        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++)
            for (int j = 0 ; j < nCol ; j++)
                tableData[i][j] = dtm.getValueAt(i,j);
        return tableData;
    }

    public void creatNewInvoice(){
    action = actions.save;
        int count=0;
        for (int i = 1; i <= controller.myListLength(); i++){

            count+=1;
        }

        invoiceNumber.setText(String.valueOf(count+1));
       ClearTextData();


        detailsModelTable.setNumRows(0);


            }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "load":
                openFile();
                break;
            case "delete":
               controller.deleteRow(detailsModelTable,invoiceTable,dtm);
                break;
            case "cancel":
                cancelUpdate();
                break;
            case "save":
                controller.savefile(mainFilePath);
                break;
            case "saveUpdate":
                saveUpdate();
                break;
            case "NewInvoice":
                creatNewInvoice();
                break;

        }

    }
}
