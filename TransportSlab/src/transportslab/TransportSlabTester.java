package transportslab;

import javax.swing.JFrame;

/**
 *
 * @author jmh463
 */
public class TransportSlabTester
{

    /**
     * This tests the TransportSlab.java class using different numbers of sections.
     * @param args not used
     */
    public static void main(String[] args)
    {
        System.out.println("Estimation at 100 sections: ");
        TransportSlab slab1 = new TransportSlab(10000,1,5,100);
        System.out.println();
        System.out.println("Estimation at 1000 sections: ");
        TransportSlab slab2 = new TransportSlab(10000,1,5,1000);
        System.out.println();
        System.out.println("Estimation at 10000 sections: ");
        TransportSlab slab3 = new TransportSlab(10000,1,5,10000);
        
        JFrame frame = new JFrame("Attenuated Profile");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        TransportSlabGraph component = new TransportSlabGraph();
        component.attProfileArray(slab1.analytical(),slab1.euler(),slab1.monteCarlo(),slab1.getThickness());
        frame.add(component);
        frame.setVisible(true);
    }
}