import java.awt.*;
import java.io.IOException;

////////////////////////////////////////////////////////////////////////////////
//Creation Date: 2017-02-22
//Created By: Austin Formagin
//This is the "main" class or the client class. From here is where the user will
//play the game from, and where it will be launched from the title screen.
////////////////////////////////////////////////////////////////////////////////
//public class Launch {
 //   public static void main (String[]args) throws IOException
   // {

        //System.out.print("Hello World");//Out puts hello world when launched. Just so it does something for now
   // }
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
//import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
//import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

    public class RunGame {

        public static void main(String[] args) {
            new RunGame();
        }

        public RunGame() {
            EventQueue.invokeLater(new Runnable(){
                @Override
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    JFrame frame = new JFrame("Dungeon Delve");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new TestPane());
                    frame.pack();
                    frame.setBackground(Color.green);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            });
        }

        public interface Mover {

            public enum Direction {

                LEFT, RIGHT, UP, DOWN, NONE, SPACE
            }

            public void setDirection(Direction direction);

            public Direction getDirection();

        }

        public class TestPane extends JPanel implements Mover {

            private BufferedImage left;
            private BufferedImage right;
            private BufferedImage stand;

            private BufferedImage current;
            private Direction direction = Direction.NONE;
            private int xPos;
            private int yPos;

            public TestPane() {
                try {
                    left = ImageIO.read(getClass().getResource("/Left.png"));
                    right = ImageIO.read(getClass().getResource("/Right.png"));
                    stand = ImageIO.read(getClass().getResource("/Stand.png"));
                    current = stand;
                    xPos = 100 - (current.getWidth() / 2);
                    yPos = 100 - (current.getHeight() / 2);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }

                bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,   0, false), new MoveAction(this, Direction.LEFT));
                bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "stop.left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,   0, true), new MoveAction(this, Direction.NONE));

                bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), new MoveAction(this, Direction.RIGHT));
                bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "stop.right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), new MoveAction(this, Direction.NONE));

                bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), new MoveAction(this, Direction.UP));
                bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "stop.up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), new MoveAction(this, Direction.NONE));

                bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), new MoveAction(this, Direction.DOWN));
                bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "stop.down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), new MoveAction(this, Direction.NONE));

                bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "move.space", KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), new MoveAction(this, Direction.SPACE));
                bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "stop.space", KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), new MoveAction(this, Direction.NONE));

                Timer timer = new Timer(40, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updatePosition();
                        repaint();
                    }
                });
                timer.start();
            }

            protected void bindKeyStrokeTo(int condition, String name, KeyStroke keyStroke, Action action) {
                InputMap im = getInputMap(condition);
                ActionMap am = getActionMap();

                im.put(keyStroke, name);
                am.put(name, action);
            }

            @Override
            public Direction getDirection() {
                return direction;
            }

            @Override
            public void setDirection(Direction direction) {
                this.direction = direction;
            }

            protected void updatePosition() {

                switch (getDirection()) {
                    case LEFT:
                        current = left;

                        xPos -= 5;
                        System.out.println("X: " + xPos);
                        break;
                    case RIGHT:
                        current = right;
                        xPos += 5;
                        System.out.println("X: " + xPos);
                        break;
                    case NONE:
                        current = stand;
                        break;

                    case DOWN:
                        current = right;
                        yPos += 5;
                        System.out.println("Y: " + yPos);
                        break;

                    case UP:
                        current = left;
                        yPos -= 5;
                        System.out.println("Y: " + yPos);
                        break;
                    case SPACE:
                        current = left;
                       // for(int yPos2 = yPos + 1; yPos2 < yPos; yPos2++){
                        if (yPos > -current.getHeight() + 50) {
                            try {
                                yPos = yPos - 5;
                                Thread.sleep(1000/30);
                                xPos = xPos + 5;
                                Thread.sleep(1000/30);
                                yPos = yPos - 5;
                                Thread.sleep(1000/30);
                                yPos = xPos + 5;
                                Thread.sleep(1000/30);
                                yPos = yPos + 5;
                               // xPos++;
                               // yPos -= (int) ((1/2) * Math.pow(xPos++, 2));
                                //Thread.sleep(50);
                                //yPos += (int) Math.pow(xPos++, 2);
                                //System.out.print("TEST");
                                System.out.println("X: " + xPos + " Y: " + yPos);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.print("ERROR");
                            }
                        }
                       // }
                        //yPos -=(xPos)^2;
                       // yPos +=(xPos)^2;
                }

                //Keeps the sprites from going off of the screen
                if (yPos < 0)
                    yPos = 0;
                else if (yPos + current.getHeight() > getHeight()){
                    current = stand;
                    yPos = getHeight() - current.getHeight();
                }
                if (xPos < 0) {
                    xPos = 0;
                    current = stand;
                } else if (xPos + current.getWidth() > getWidth()) {
                    current = stand;
                    xPos = getWidth() - current.getWidth();
                }
                //End of sprite limits
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(current, xPos, yPos, this);
                g2d.dispose();
            }

        }

        public class MoveAction extends AbstractAction {

            private Mover mover;
            private Mover.Direction direction;

            public MoveAction(Mover mover, Mover.Direction direction) {
                this.mover = mover;
                this.direction = direction;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                mover.setDirection(direction);
            }

        }

    }

