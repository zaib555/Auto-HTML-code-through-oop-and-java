import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class HTML5Editor extends JFrame
{
   private JPanel unorderedListPanel;
   private JLabel unorderedListLabel;
   private JTextField unorderedListTextField;
   private JButton unorderedListButton;
   private JPanel imagePanel;
   private JLabel imageLabel;
   private JTextField imageTextField;
   private JButton imageButton;
   private JPanel linkPanel;
   private JLabel linkLabel;
   private JTextField linkTextField;
   private JButton linkButton;
   private JPanel buttonPanel;
   private JButton saveButton;
   private JButton exitButton;
   
   private static final int WIDTH = 700;
   private static final int HEIGHT = 600;
   
   public HTML5Editor()
   {
      setTitle("HTML5 Editor");
      
      setSize(WIDTH, HEIGHT);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      buildUnorderedListPanel();
      buildImagePanel();
      buildLinkPanel();
      buildButtonPanel();
      
      setLayout(new GridLayout(4, 1));
      
      add(unorderedListPanel);
      add(imagePanel);
      add(linkPanel);
      add(buttonPanel);
      
      setVisible(true);
   }
   
   private void buildUnorderedListPanel()
   {
      unorderedListLabel = new JLabel("Unordered List:");
      
      unorderedListTextField = new JTextField(50);
      
      unorderedListButton = new JButton("Add to list");
      
      unorderedListButton.addActionListener(new UnorderedListListener());
      
      unorderedListPanel = new JPanel();
      
      unorderedListPanel.add(unorderedListLabel);
      unorderedListPanel.add(unorderedListTextField);
      unorderedListPanel.add(unorderedListButton);
   }
   
   private void buildImagePanel()
   {
      imageLabel = new JLabel("Image:");
      
      imageTextField = new JTextField(50);
      
      imageButton = new JButton("Add to list");
      
      imageButton.addActionListener(new ImageListener());
      
      imagePanel = new JPanel();
      
      imagePanel.add(imageLabel);
      imagePanel.add(imageTextField);
      imagePanel.add(imageButton);
   }
   
   private void buildLinkPanel()
   {
      linkLabel = new JLabel("Link:");
      
      linkTextField = new JTextField(50);
      
      linkButton = new JButton("Add to list");
      
      linkButton.addActionListener(new LinkListener());
      
      linkPanel = new JPanel();
      
      linkPanel.add(linkLabel);
      linkPanel.add(linkTextField);
      linkPanel.add(linkButton);
   }
   
   private void buildButtonPanel()
   {
      saveButton = new JButton("Save");
      
      exitButton = new JButton("Exit");
      
      buttonPanel = new JPanel();
      
      buttonPanel.add(saveButton);
      buttonPanel.add(exitButton);
      
      exitButton.addActionListener(new ExitListener());
      saveButton.addActionListener(new SaveListener());
   }
   
   private class ExitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
   
   private class SaveListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         String input;
         
         int dialogButton = JOptionPane.YES_NO_OPTION;
         
         input = JOptionPane.showInputDialog("Enter file name");
         
         if (input == null)
         {
            JOptionPane.showMessageDialog(null, "No file name entered", 
                  "Error", dialogButton);
         }
         else
         {
            try
            {
               PrintWriter outFile = new PrintWriter(input);
               
               outFile.println("<!DOCTYPE html>");
               outFile.println("<html>");
               outFile.println("<head>");
               outFile.println("</head>");
               outFile.println("<body>");
               outFile.println(unorderedListTextField.getText());
               outFile.println(imageTextField.getText());
               outFile.println(linkTextField.getText());
               outFile.println("</body>");
               outFile.println("</html>");
               
               outFile.close();
            }
            catch(IOException e1)
            {
               JOptionPane.showMessageDialog(null, "Error processing file",
                     "Error", dialogButton);
            }
         }
      }
   }
   
   private class UnorderedListListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         String input;
         
         int dialogButton = JOptionPane.YES_NO_OPTION;
         
         input = JOptionPane.showInputDialog("Enter list item");
         
         if (input == null)
         {
            JOptionPane.showMessageDialog(null, "No item entered", 
                  "Error", dialogButton);
         }
         else
         {
            unorderedListTextField.setText(unorderedListTextField.getText() 
                  + "\n<li>" + input + "</li>");
         }
      }
   }
   
   private class ImageListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         String input;
         
         int dialogButton = JOptionPane.YES_NO_OPTION;
         
         input = JOptionPane.showInputDialog("Enter image URL");
         
         if (input == null)
         {
            JOptionPane.showMessageDialog(null, "No URL entered", 
                  "Error", dialogButton);
         }
         else
         {
            imageTextField.setText(imageTextField.getText() + "\n<img src=\"" 
                  + input + "\">");
         }
      }
   }
   
   private class LinkListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         String input;
         
         int dialogButton = JOptionPane.YES_NO_OPTION;
         
         input = JOptionPane.showInputDialog("Enter link URL");
         
         if (input == null)
         {
            JOptionPane.showMessageDialog(null, "No URL entered", 
                  "Error", dialogButton);
         }
         else
         {
            linkTextField.setText(linkTextField.getText() + "\n<a href=\"" 
                  + input + "\">Link</a>");
         }
      }
   }
   
   public static void main(String[] args)
   {
      new HTML5Editor();
   }
}