package View;

import Model.InvoiceItems;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewItem extends JFrame implements ActionListener{

    private JButton add;
    private JTextField count;
    private JLabel invoiceNumber;
    private JTextField itemName;
    private JTextField itemPrice;
    private JLabel itemTotal;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private FormDesign items;


    public void saveItem(){
        int id =Integer.parseInt(invoiceNumber.getText());
       String name =  itemName.getText();
       float price = Float.parseFloat(itemPrice.getText());
       int itemCount = Integer.parseInt(count.getText());
        InvoiceItems data = new InvoiceItems(id,name,price,itemCount);
        data.totalInvoice=itemCount*price;
        items.saveItem(data);

    }

    public void initComponents( FormDesign items,int id) {
        this.items = items;
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        invoiceNumber = new JLabel();
        itemName = new JTextField();
        itemPrice = new JTextField();
        count = new JTextField();
        add = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Item Name");

        jLabel3.setText("Item Price");

        jLabel4.setText("Count");


        add.setText("add");
        add.setAutoscrolls(true);

        add.addActionListener(this);
        add.setActionCommand("addItem");

        invoiceNumber.setText(Integer.toString(id));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel1))
                                .addGap(270, 270, 270)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(invoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(add)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(itemName, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                                                        .addComponent(itemPrice)
                                                        .addComponent(count))))
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(invoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel2))
                                        .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addComponent(add)
                                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "addItem":
                saveItem();
                break;

        }

    }

}
