package transportslab;

import java.awt.*;
import java.awt.geom.Line2D;
import java.math.*;
import javax.swing.JPanel;

/**
 * 
 * @author jmh463
 */
public class TransportSlabGraph extends JPanel
{
    double[] N, N2, N3, xAxes, yAxes, yAxes2, yAxes3;
    final int edge = 80; //Distance from edge of frame
    String[] xlabel = new String[11];
    String[] ylabel = new String[11];
    
    /**
     * This method stores the data arrays to later be scaled and converted to
     * pixel coordinates.
     * @param inputN Analytical Profile of type {@code double[]}
     * @param inputN2 Euler Profile of type {@code double[]}
     * @param inputN3 Monte Carlo Profile of type {@code double[]}
     * @param thickness Thickness set by the original constructor
     */
    public void attProfileArray(double[] inputN, double[] inputN2, double[] inputN3, double thickness)
    {
        N = new double[inputN.length];
        N2 = new double[inputN.length];
        N3 = new double[inputN.length];
        //Create labels for the tick marks of the x and y axis from rounded #'s
        BigDecimal bd1, bd2;
        for (int i = 0; i <= 10; i++)
        {
            bd1 = new BigDecimal((thickness/10)*i);
            MathContext mc = new MathContext(2); //Round to one decimal place
            bd2 = bd1.round(mc);
            xlabel[i] = String.valueOf(bd2.doubleValue());
            ylabel[i] = String.valueOf((inputN[0]*i)/(inputN.length-1));
        }
        //Set up data array and the axes
        for (int i = 0; i < N.length; i++)
        {
            N[i]=inputN[i];
            N2[i]=inputN2[i];
            N3[i]=inputN3[i];
            xAxes = new double[N.length];
            yAxes = new double[N.length];
            yAxes2 = new double[N.length];
            yAxes3 = new double[N.length];
        }
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //Get frame dimensions to scale drawn components
        int w = getWidth();
        int h = getHeight();
        double xInc = (double)(w-2*edge)/(N.length-1);
        double scale = (double)(h-2*edge)/N[0];
        g2.draw(new Line2D.Double(edge, h-edge, w-edge, h-edge)); //draw x axis
        g2.draw(new Line2D.Double(edge, edge, edge, h-edge)); // draw y axis
        //Create evenly spaced tick marks for both axes and label them
        for (int i = 0; i <= 10; i++)
        {
            g2.draw(new Line2D.Double(edge+((w-edge-edge)/10.0)*i, h-edge-10, edge+((w-edge-edge)/10.0)*i, h-edge+10)); //x ticks
            g2.draw(new Line2D.Double(edge-10, h-edge-((h-edge-edge)/10.0)*i, edge+10, h-edge-((h-edge-edge)/10.0)*i)); //y ticks
            g2.drawString(xlabel[i],(int)(edge+((w-edge-edge)/10.0)*i),h-edge+20);
            g2.drawString(ylabel[i],edge-30,(int)(h-edge-((h-edge-edge)/10.0)*i));
        }
        g2.drawString("Attenuated Profile Plot", w/2-50, edge/2);
        g2.drawString("N(x)",(edge/4),(h/2));
        g2.drawString("Position (cm)",(w/2),(h-edge/2));
        //Scale data and convert to pixel coordinates
        for (int i = 0; i < N.length; i++)
        {
            xAxes[i] = edge+i*xInc;
            yAxes[i] = h-edge-scale*N[i];
            yAxes2[i] = h-edge-scale*N2[i];
            yAxes3[i] = h-edge-scale*N3[i];
        }
        //Draw the data as a series of line segments
        for (int i = 1; i < N.length; i++)
        {
            g2.setPaint(Color.RED);
            g2.draw(new Line2D.Double(xAxes[i-1],yAxes[i-1],xAxes[i],yAxes[i]));
            g2.setPaint(Color.BLUE);
            g2.draw(new Line2D.Double(xAxes[i-1],yAxes2[i-1],xAxes[i],yAxes2[i]));
            g2.setPaint(Color.GREEN);
            g2.draw(new Line2D.Double(xAxes[i-1],yAxes3[i-1],xAxes[i],yAxes3[i]));
        }
    }
}