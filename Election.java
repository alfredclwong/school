package Election;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Election implements ActionListener {
  static final int a = 5;
  static int b, c[][] = new int[a][a], d[][] = new int[a][a], e[] = new int[a];
  static boolean f = false;
  static final Color g = Color.GRAY;
  static String h = "Click on candidate names in order of preference",
      k = "'Reset': new ballot; 'Finish': election results!",
      l[] = new String[a], m;
  static final JFrame n = new JFrame("Ballot paper");
  static final JPanel o = new JPanel(new BorderLayout()), p = new JPanel(
      new GridLayout(a, 1)), q = new JPanel(new GridLayout(a, 1)),
      r = new JPanel(new GridLayout(1, 2));
  static final JLabel s[] = new JLabel[a], t = new JLabel(h);
  static final JButton u[] = new JButton[a], v = new JButton("Finish"),
      w = new JButton("Reset");
  static final Election x = new Election();
  static Scanner y;
  public static void main(String[] z) {
    n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    n.setContentPane(Election.o);
    y = new Scanner(System.in);
    for (int i = 0; i < a; i++) {
      System.out.println("Candidate #" + (i + 1) + " name: ");
      l[i] = y.next();
      s[i] = new JLabel("  #" + (i + 1) + "  ");
      p.add(s[i]);
      u[i] = new JButton(l[i]);
      u[i].addActionListener((ActionListener) x);
      q.add(u[i]);
    }
    y.close();
    w.addActionListener((ActionListener) x);
    v.addActionListener((ActionListener) x);
    r.add(w);
    r.add(v);
    o.add("South", r);
    o.add("West", p);
    o.add("Center", q);
    o.add("North", t);
    n.pack();
    n.setVisible(true);
  }
  @Override public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == w) {
      b = 0;
      for (int i = 0; i < a; i++) {
        u[i].setText(l[i]);
        u[i].setBackground(null);
      }
      t.setText(h);
      d = new int[a][a];
    } else if (ae.getSource() == v) {
      n.dispose();
      for (int i = 0; i < a * a; i++)
        e[i % a] += c[i / a][i % a] * -(i / a + 1);
      for (int i = 0; i <= a; i++) {
        System.out.println("#" + i + " " + Arrays.toString(e));
        b = 0;
        for (int j = 1; j < a; j++)
          if (e[j] > e[b]) {
            f = false;
            b = j;
          } else if (e[j] == e[b]) f = true;
        if (!f) {
          System.out.println("The winner is " + l[b]);
          return;
        } else if (i == a) {
          System.out.println("Draw");
          return;
        }
        for (int j = 0; j < a; j++)
          if (e[j] != e[b]) c[i][j] = -1;
        e = c[i];
      }
    } else for (int i = 0; i < a; i++)
      if (ae.getSource() == u[i] && i >= b) {
        m = u[b].getText();
        u[b].setText(u[i].getText());
        u[b].setBackground(g);
        u[i].setText(m);
        for (int j = 0; j < a; j++)
          if (l[j] == u[b].getText()) {
            d[b++][j]++;
            break;
          }
        if (b == a) {
          t.setText(k);
          for (int j = 0; j < a * a; j++)
            c[j / a][j % a] += d[j / a][j % a];
          d = new int[a][a];
        }
        break;
      }
  }
}
