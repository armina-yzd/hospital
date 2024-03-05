public class JListOperations extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private javax.swing.JScrollPane jsp = null;
    private javax.swing.JList<java.lang.String> jl = null;
    public JListOperations(){
        super();
    }
    public void initialiseComponents(){
        jl = new javax.swing.JList<java.lang.String>(new java.lang.String[]{"Item 1"});
        /*
         * Add mouse listener which checks if the mouse click point is on the item. If not deselect the item
         */
        jl.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent mouseEvent){
                if (!jl.getCellBounds(jl.getSelectedIndex(), jl.getSelectedIndex()).contains(mouseEvent.getPoint())){
                    jl.removeSelectionInterval(jl.getSelectedIndex(), jl.getSelectedIndex());
                }
                java.lang.System.out.println(jl.getSelectedIndex());
            }
        });
        jsp = new javax.swing.JScrollPane(jl);
        getContentPane().add(jsp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    // public static void main(java.lang.String args[]){
    //     JListOperations jlopFrame = new JListOperations();
    //     jlopFrame.initialiseComponents();
    //     jlopFrame.pack();
    //     jlopFrame.setVisible(true);
    // }
}