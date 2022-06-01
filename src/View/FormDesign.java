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
    private JButton deleteDetails;
    private JButton addDetails;
    private JButton AddItem;
    private JButton deleteItem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;

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

    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        invoiceTable = new JTable();
        deleteInvoice = new JButton();
        newInvoice = new JButton();
        jScrollPane2 = new JScrollPane();
        invoiceItems = new JTable();
        saveUpdate = new JButton();
        cancel = new JButton();
        invoiceNumber = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        invoiceDate = new JTextField();
        customerName = new JTextField();
        invoiceSum = new JLabel();
        jLabel6 = new JLabel();
        addDetails = new JButton();
        deleteDetails = new JButton();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        loadFileItem = new JMenuItem();
        SaveFileItem = new JMenuItem();

        AddItem = new JButton();
        deleteItem = new JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(invoiceTable);

        deleteInvoice.setText("Delete Invoice");


        newInvoice.setText("Create New Invoice");


        jScrollPane2.setViewportView(invoiceItems);

        saveUpdate.setText("Save Update");

        cancel.setText("Cancel");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");


        jLabel6.setText("Invoice Number");

        AddItem.setText("Add Item");

        deleteItem.setText("Delete Item");

        addDetails.setText("Add Details");


        deleteDetails.setText("Delete Details");


        fileMenu.setText("File");

        loadFileItem.setText("Load File");

        fileMenu.add(loadFileItem);

        SaveFileItem.setText("Save File");
        fileMenu.add(SaveFileItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(newInvoice)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteInvoice)))
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(saveUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel6)
                                                        .addComponent(AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(41, 41, 41)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(invoiceDate, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                                        .addComponent(customerName)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(invoiceSum, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(29, 29, 29))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addGap(28, 28, 28)
                                                                                .addComponent(invoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(deleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(newInvoice)
                                                        .addComponent(deleteInvoice))
                                                .addContainerGap(182, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(invoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(invoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(44, 44, 44)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(invoiceSum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(AddItem)
                                                        .addComponent(deleteItem))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(saveUpdate)
                                                        .addComponent(cancel))
                                                .addGap(11, 11, 11))))
        );

        pack();
    }// </editor-fold>`
public void setFormLayout(){


//    mainPanel = new JPanel(new GridLayout(1, 2));
//    leftPanel = new JPanel(new FlowLayout());
//    rightPanel = new JPanel(new GridLayout(2, 1));
//    customerPanel = new JPanel(new GridLayout(4, 2));
//    customerInvoiceTable=new JPanel(new FlowLayout());
//    rightPanel.add(customerPanel);




//    mainPanel.add(leftPanel);
//    mainPanel.add(rightPanel);

    //Menu

//    menuBar = new JMenuBar();
//    loadFileItem = new JMenuItem("Load File");
    loadFileItem.addActionListener(this);
    loadFileItem.setActionCommand("load");
//    SaveFileItem = new JMenuItem("Save File");
    SaveFileItem.addActionListener(this);
    SaveFileItem.setActionCommand("save");

//    fileMenu = new JMenu("File");
//    fileMenu.add(loadFileItem);
//    fileMenu.add(SaveFileItem);
//    menuBar.add(fileMenu);
//    setJMenuBar(menuBar);
    //Table


//    invoiceTable = new JTable();
//    leftPanel.add(new JScrollPane(invoiceTable));


    //Buttons
//    newInvoice = new JButton("Create New Invoice");
//    leftPanel.add(newInvoice);
//    deleteInvoice = new JButton("Delete Invoice");
//    leftPanel.add(deleteInvoice);


//    JLabel invoiceLabel =new JLabel("Invoice Number");
//    customerPanel.add(invoiceLabel);
//    invoiceNumber = new JLabel();
//
//    customerPanel.add((invoiceNumber));
//    invoiceDate = new JTextField("");
//    customerPanel.add(new JLabel("Invoice Date"));
//
//    customerPanel.add(invoiceDate);
//
//    customerName = new JTextField("");
//    customerPanel.add(new JLabel("Customer Name"));
//
//    customerPanel.add(customerName);
//
//    customerPanel.add(new JLabel("Invoice Total"));
//    invoiceSum = new JLabel();
//    customerPanel.add(invoiceSum);
//
//    rightPanel.add(customerPanel);
//
//    invoiceItems = new JTable();
//    customerInvoiceTable.add(new JScrollPane(invoiceItems));
//    rightPanel.add(customerInvoiceTable);


    //Buttons
//    deleteDetails = new JButton("Delete Details");
//    customerInvoiceTable.add(deleteDetails);
//
//    addDetails = new JButton("Add Details");
//    customerInvoiceTable.add(addDetails);
//    saveUpdate = new JButton("saveUpdate");
//    customerInvoiceTable.add(saveUpdate);
//
//    cancel = new JButton("Cancel");
//    customerInvoiceTable.add(cancel);
//
//
//
//    add(mainPanel);

    //Form
    setSize(1000, 600);
    setLocation(0, 0);
//    Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
//    setMaximumSize(DimMax);
//
//    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



}
    public FormDesign() {

        super("Design Preview (New Form)");

        this.initComponents();
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
                float totalInvoice = 0;

                for (int i = 0; i < controller.myInvoiceListItemLength(); i++) {

                    if (dataId == controller.myInvoiceItems(i).invoiceNumber){
                        InvoiceItems tableRow = controller.myInvoiceItems(i);
                        float totalCount = tableRow.itemPrice * tableRow.numberOfItemsPurchased;
                        totalInvoice += totalCount;
                        tableRow.totalInvoice = totalCount;
                        detailsModelTable.addRow(tableRow.getDetailed());
                    }

                }
                invoiceSum.setText(Float.toString(totalInvoice));

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



        deleteDetails.addActionListener(this);
        deleteDetails.setActionCommand("deleteDetails");

        AddItem.addActionListener(this);
        AddItem.setActionCommand("AddItem");

        deleteItem.addActionListener(this);
        deleteItem.setActionCommand("deleteItem");

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
        float invoicetot = (float) invoiceTable.getValueAt(selectedRow, 3);
        invoiceNumber.setText(dataId);
        invoiceDate.setText(invdate);
        customerName.setText(name);
        invoiceSum.setText(Float.toString(invoicetot));


    }


    public void saveInvoice(InvoiceHeader data) {


            controller.addToMyListdata(data);




        controller.savefile(mainFilePath);
        dtm.setNumRows(0);

        for (int i = 0; i <controller.myListLength(); i++) {
            InvoiceHeader tableRow = controller.myListValues(i);
            dtm.addRow(tableRow.getArray());
        }
        invoice.setVisible(false);
    }


    public void saveItem(InvoiceItems data) {


        controller.addToListDetails(data);




        controller.savefile(mainFilePath);
        detailsModelTable.setNumRows(0);

        for (int i = 0; i <controller.myInvoiceListItemLength(); i++) {
            InvoiceItems tableRow = controller.myInvoiceItems(i);
            if(data.invoiceNumber==tableRow.invoiceNumber) {
                detailsModelTable.addRow(tableRow.getDetailed());
            }
        }
        dtm.setNumRows(0);
       controller.RefreshInvoiceTable(dtm);
       item.setVisible(false);
    }

    public void saveDetailstoPath(){
        controller.savefile(mainFilePath);
        dtm.setNumRows(0);
        controller.RefreshInvoiceTable(dtm);
        item.setVisible(false);
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
      NewInvoice invoice = new NewInvoice();
    public void creatNewInvoice(){


        invoice.setVisible(true);

        invoice.initComponents(this,controller.myListLength()+1);



        action = actions.save;
//        int count=0;
//        for (int i = 1; i <= controller.myListLength(); i++){
//
//            count+=1;
//        }

        invoiceNumber.setText(String.valueOf(controller.myListLength()+1));
       ClearTextData();


        detailsModelTable.setNumRows(0);


            }
     NewItem item = new NewItem();
            public void createNewItem(){
         int dataId;
                int selectedRow = invoiceTable.getSelectedRow();
                dataId = (int)invoiceTable.getValueAt(selectedRow, 0);


             item.setVisible(true);
             item.initComponents(this,dataId);

            }

    public void deleteItem(){

          controller.deleteItemRow(detailsModelTable,invoiceItems);
        saveDetailstoPath();

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
            case "AddItem":
                createNewItem();
                break;
            case "deleteItem":
                deleteItem();
                break;
//            case "deleteDetails":
//                controller.deleteDetails(detailsModelTable,invoiceItems);

        }

    }
}
