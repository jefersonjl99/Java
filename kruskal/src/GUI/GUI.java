package GUI;
import Graph.Nodo;
import Graph.Arista;
import Algorithm.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GUI extends JFrame {
    private JButton saveButton = new JButton(new ImageIcon("src\\save.png"));
    private JButton loadButton = new JButton(new ImageIcon("src\\load.png"));

    private JButton colorNodes = new JButton("color nodos");
    private JButton colorEdge = new JButton("color uniones");
    private JButton colorFlood = new JButton("Reiniciar");
    private JButton thickness = new JButton("Instrucciones rusas");

    private JButton buttonStart = new JButton(new ImageIcon("src\\start.png"));
    private JButton buttonSkip = new JButton(new ImageIcon("src\\skip.png"));
    private JButton nextStep = new JButton(new ImageIcon("src\\next.png"));
    private JButton prevStep = new JButton(new ImageIcon("src\\prev.png"));
  
    GraphFactory factoryGraph = new GraphFactory();
    NodeFactory factoryNode = new NodeFactory();
    EdgeFactory factoryEdge = new EdgeFactory();
    
    Arbol arbol=new Arbol();
    String aristas[][];
    boolean edgeAddFlag = false;
    Nodo saveNode;
    int index = 0;
    int collisionBreaker = 2;
    
    public JLabel titulo1;
    public JLabel titulo2;
    
    public GUI() {
        super("GraphAnalyzer Algorithm");

        this.setBounds(500,200,1000,700);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel panel1 = new JPanel();
        //panel1.setLayout(new GridBagLayout());
        panel1.setBackground(new Color(0, 170, 0));

        
        
        colorFlood.setBackground(new Color(0, 120, 0));
        colorFlood.setForeground(new Color(255, 255, 255));
        colorFlood.setBorderPainted(false);
        colorFlood.setFocusPainted(false);
        colorFlood.setBounds(120, 10, 100, 50);
        this.add(colorFlood);
        
        buttonSkip.setBackground(new Color(0, 170, 0));
        buttonSkip.setBorderPainted(false);
        buttonSkip.setFocusPainted(false);
        buttonSkip.setBounds(10, 10, 100, 50);
        this.add(buttonSkip);
        
        jPanel2 holst = new jPanel2();
        holst.setLayout(null);
        holst.setBackground(new Color(100, 100, 100));
        holst.setBounds(10,100,500,600);
       
        this.add(holst);
        
        jPanel2 holst2 =new jPanel2();
        holst2.setLayout(null);
        holst2.setBackground(new Color(100, 100, 100));
        holst2.setBounds(520,100,500,600);
        this.add(holst2);
        
        titulo1 = new JLabel ("Grafo original");
        titulo1.setBounds(5, 10, 100, 20);
        holst2.add(titulo1);
        
        titulo2 = new JLabel ("Grafo con ruta minima");
        titulo2.setBounds(5, 10, 200, 20);
        holst.add(titulo2);
        //GridBagConstraints c = new GridBagConstraints();
/*
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = -50;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(2, 0, 0, 0);
*/
        saveButton.setBackground(new Color(0, 170, 0));
        saveButton.setBorderPainted(false);
        saveButton.setFocusPainted(false);
        saveButton.setBounds(300,30, 50, 50);
        
         this.add(saveButton);
/*
       

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = -50;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(1, 0, 2, 0);

        loadButton.setBackground(new Color(0, 170, 0));
        loadButton.setBorderPainted(false);
        loadButton.setFocusPainted(false);

        panel1.add(loadButton, c);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel2.setBackground(new Color(0, 170, 0));

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = 5;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0, 0, 0, 0);

        colorNodes.setBackground(new Color(0, 120, 0));
        colorNodes.setForeground(new Color(255, 255, 255));
        colorNodes.setBorderPainted(false);
        colorNodes.setFocusPainted(false);

        //panel2.add(colorNodes, c);

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = 20;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0, 0, 0, 0);

        colorEdge.setBackground(new Color(0, 120, 0));
        colorEdge.setForeground(new Color(255, 255, 255));
        colorEdge.setBorderPainted(false);
        colorEdge.setFocusPainted(false);

        //panel2.add(colorEdge, c);

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = 35;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0, 0, 0, 0);

        colorFlood.setBackground(new Color(0, 120, 0));
        colorFlood.setForeground(new Color(255, 255, 255));
        colorFlood.setBorderPainted(false);
        colorFlood.setFocusPainted(false);

        panel2.add(colorFlood, c);

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = 35;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0, 0, 0, 0);

        thickness.setBackground(new Color(0, 120, 0));
        thickness.setForeground(new Color(255, 255, 255));
        thickness.setBorderPainted(false);
        thickness.setFocusPainted(false);

        //panel2.add(thickness, c);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panel3.setBackground(new Color(0, 170, 0));

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = -50;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(2, 0, 1, 0);

        prevStep.setBackground(new Color(0, 170, 0));
        prevStep.setBorderPainted(false);
        prevStep.setFocusPainted(false);

        //panel3.add(prevStep, c);

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = -50;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(2, 0, 1, 0);

        nextStep.setBackground(new Color(0, 170, 0));
        nextStep.setBorderPainted(false);
        nextStep.setFocusPainted(false);

        //panel3.add(nextStep, c);

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = -50;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(1, 0, 4, 0);

        buttonStart.setBackground(new Color(0, 170, 0));
        buttonStart.setBorderPainted(false);
        buttonStart.setFocusPainted(false);

        //panel3.add(buttonStart, c);

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = -50;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0, 0, 2, 0);

        buttonSkip.setBackground(new Color(0, 170, 0));
        buttonSkip.setBorderPainted(false);
        buttonSkip.setFocusPainted(false);

        panel3.add(buttonSkip, c);

        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        panel4.setBackground(new Color(0, 0,0));
        
       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3,0,0));
        //panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        //panel.add(panel4);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = 0;
        c.ipady = -55;
        c.weightx = 0;
        c.weighty = 0;
        c.insets = new Insets(0, 0, 0, 0);

        this.add(panel, c);

        
        //------------------------------------------------------------------------------------------------------- 
        
        
  */     

        thickness.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "1.", "Instrucciones", JOptionPane.PLAIN_MESSAGE);
            }
        });

        loadButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog((Dialog) null, "cargar", FileDialog.LOAD);
                fd.setDirectory("C:\\");
                fd.setVisible(true);

                String filename = fd.getFile();

                if (filename == null){
                    return;
                }

                Grafo loadedGraph = Grafo.load(filename);

                holst.testList = loadedGraph.getNodeList();
                holst.testListEdges = loadedGraph.getEdgeList();

                factoryEdge = new EdgeFactory();
                factoryGraph = new GraphFactory();
                factoryNode = new NodeFactory();
                holst.repaint();
            }

        });

        saveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //NodoArbol nodo = new NodoArbol(0);
                Dibuja d = new Dibuja();
                //
                System.out.println("primer elemento: "+ arbol.getRaiz().clave);
                d.DibujaArbol(holst.getGraphics(), 200, 100, arbol.getRaiz());
//                
//                FileDialog fd = new FileDialog((Dialog) null, "guardar", FileDialog.SAVE);
//                fd.setDirectory("C:\\");
//                fd.setVisible(true);
//
//                String filename = fd.getFile();
//
//                if (filename == null){
//                    return;
//                }
//
//                Grafo toBeSaved = factoryGraph.getGraph(holst.testListEdges, holst.testList);
//
//                toBeSaved.save(filename);
//            }
//
//        });
            }
        });
       
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (holst.testList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "start", "star", JOptionPane.PLAIN_MESSAGE);

                    return;
                }
                index = 0;

                holst.after = new ArrayList<Arista>();

                Grafo ready = new Grafo(holst.testListEdges, holst.testList);

                if ((ready.isConnected())) {
                    GraphAnalyzer analyzer= new GraphAnalyzer();
                    ready = analyzer.KruskalAnalyze(ready);

                    holst.testListEdges = new ArrayList<Arista>();

                    holst.after = ready.getEdgeList();
                }
                else
                    JOptionPane.showMessageDialog(null, "Граф не связный!", "Ошибка", JOptionPane.PLAIN_MESSAGE);

                holst.repaint();
            }
        });

        nextStep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!holst.after.isEmpty()) {
                    try {
                        holst.testListEdges.add(holst.after.get(index));
                        ++index;

                        holst.repaint();
                    }
                    catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Остовное дерево получено!", "", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Алгоритм еще не применен!", "Ошибка", JOptionPane.PLAIN_MESSAGE);
            }
        });

        prevStep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!holst.after.isEmpty()) {
                    try {
                        holst.testListEdges.remove(index - 1);
                        --index;
                        holst.repaint();
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Вы на начальном шаге!", "", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Алгоритм еще не применен!", "Ошибка", JOptionPane.PLAIN_MESSAGE);
            }
        });

        buttonSkip.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Grafo ready;

                if (holst.testList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay nodos", "ADVERTENCIA", JOptionPane.PLAIN_MESSAGE);

                    return;
                }

                if (holst.after.isEmpty())
                    ready = new Grafo(holst.testListEdges, holst.testList);
                else {
                    ready = new Grafo(holst.after, holst.testList);
                    index = holst.after.size();
                }

                if ((ready.isConnected())) {
                    aristas=ready.numeroAristas();
                    
                    for(int k=0;k<aristas.length;k++){
                        for(int j=0;j<3;j++){
                            System.out.print(aristas[k][j]);
                    }
                        
                    System.out.println(" ");
                    }
                    arbol.añadirDatos(aristas);
                    GraphAnalyzer analyzer= new GraphAnalyzer();
                    ready = analyzer.KruskalAnalyze(ready);

                    holst.testListEdges = new ArrayList<Arista>();
                    holst.after = ready.getEdgeList();

                    index = holst.after.size();

                    for (Arista mda : holst.after)
                        holst.testListEdges.add(mda);
                }
                else
                    JOptionPane.showMessageDialog(null, "Error!", "error", JOptionPane.PLAIN_MESSAGE);

                holst.repaint();
                
            }

        });

        colorFlood.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                holst.testListEdges = new ArrayList<Arista>();
                holst.testList = new ArrayList<Nodo>();

                factoryEdge = new EdgeFactory();
                factoryNode = new NodeFactory();
                factoryGraph = new GraphFactory();
                holst.repaint();
            }
        });

        holst.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                boolean flag = true;

                for (Nodo v : holst.testList){
                    if  (Math.sqrt((v.getX()-evt.getX())*(v.getX()-evt.getX())+(v.getY()-evt.getY())*(v.getY()-evt.getY()))<15){
                        flag = false;

                        if (edgeAddFlag) {
                            try{
                                String string = JOptionPane.showInputDialog(null, "Que peso desea poner a la arista", "", JOptionPane.PLAIN_MESSAGE);

                                int askedWeight;

                                if (string != null) {

                                    for (Arista e : holst.testListEdges)
                                    {
                                        if((e.getFirst() == saveNode) && (e.getSecond() == v) ||
                                                (e.getFirst() == v) && (e.getSecond() == saveNode)){

                                            JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.PLAIN_MESSAGE);
                                            edgeAddFlag = false;
                                        }

                                        if((saveNode == v)){
                                        JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.PLAIN_MESSAGE);

                                    }
                                    }

                                    if(edgeAddFlag) {
                                        askedWeight = Integer.parseInt(string);
                                        holst.testListEdges.add(factoryEdge.getEdge(saveNode, v, askedWeight));
                                        holst2.testListEdges.add(factoryEdge.getEdge(saveNode, v, askedWeight));
                                    }
                                }

                                edgeAddFlag = false;
                                break;
                            }
                            catch(NumberFormatException e){
                                JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.PLAIN_MESSAGE);

                                edgeAddFlag = false;
                                break;
                            }
                            finally{
                            }
                        }

                        saveNode = v;
                        edgeAddFlag = true;
                        break;
                    }

                    else if (Math.sqrt((v.getX()-evt.getX())*(v.getX()-evt.getX())+(v.getY()-evt.getY())*(v.getY()-evt.getY()))<30){
                        JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.PLAIN_MESSAGE);

                        flag = false;
                        edgeAddFlag = false;
                        break;
                    }
               }
                if (flag) {
                    Nodo tmp = factoryNode.getNode();

                    boolean foundName = false;

                    while(!foundName) {
                        foundName = true;

                        for (Nodo e : holst.testList) {
                            if (e.getName().equals(tmp.getName())) {
                                tmp.setName(tmp.getName() + (collisionBreaker++));

                                foundName = false;
                                continue;
                            }
                        }
                    }

                    collisionBreaker = 2;

                    tmp.setX(evt.getX());
                    tmp.setY(evt.getY());

                    holst.testList.add(tmp);
                    holst2.testList.add(tmp);

                    edgeAddFlag = false;
                }

                holst.repaint();
                holst2.repaint();
                
            }
        });

        this.addWindowListener(new WindowListener() {
            public void windowActivated(WindowEvent event) {}
            public void windowClosed(WindowEvent event) {}
            public void windowDeactivated(WindowEvent event) {}
            public void windowDeiconified(WindowEvent event) {}
            public void windowIconified(WindowEvent event) {}
            public void windowOpened(WindowEvent event) {}
            public void windowClosing(WindowEvent event) {
                Object[] options = { "Si", "Cancelar" };

                int rc = JOptionPane.showOptionDialog(
                        event.getWindow(), "desea salir",
                        "salir", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                if (rc == 0) {
                    event.getWindow().setVisible(false);
                    System.exit(0);
                }
            }

        });
    }

    public class jPanel2 extends JPanel {
        ArrayList<Nodo> testList = new ArrayList<Nodo>();
        ArrayList<Arista> testListEdges = new ArrayList<Arista>();
        ArrayList<Arista> after = new ArrayList<Arista>();

        Color colorEdge = new Color(255, 255, 255);
        Color colorNode = new Color(255, 255, 255);
        Color black = new Color(0, 0, 0);

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(colorEdge);

            for (Arista p : testListEdges){
                g.drawLine(p.getFirst().getX(), p.getFirst().getY(), p.getSecond().getX(), p.getSecond().getY());

                g.drawString(Integer.toString(p.getWeight()),
                        (p.getFirst().getX() + p.getSecond().getX()) / 2 ,
                        (p.getFirst().getY() + p.getSecond().getY()) / 2 );
            }
            for (Nodo a : testList){
                g.setColor(colorNode);
                g.fillOval(a.getX() - 15, a.getY() - 15, 30, 30);

                g.setColor(black);
                g.drawString(a.getName(), a.getX() - 3, a.getY() + 3);
            }

        }
    }

    public static void execute() {
        GUI app = new GUI();
        app.setVisible(true);
    }

}