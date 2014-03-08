package week18;

import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JOptionPane;

public class Search {

	public static void main(String[] args) throws FileNotFoundException {
		InvertedFile f = new InvertedFile(JOptionPane.showInputDialog(null, "Please enter the name of the document file:")); // Get the name of the file which contains the documents and make an inverted file out of it
		
		String query = JOptionPane.showInputDialog(null, "Enter the word for which to search, or press \"Cancel\" to quit:"); // Get the query

		while (! (query == null)) { // Repeat while the user didn't press "Cancel"
			List<Integer> docs = f.get(query); // Get the document numbers for the query

			if (docs == null) { // If the list is null, the query didn't show up in the search
				JOptionPane.showMessageDialog(null, String.format("The word \"%s\" does not occur in any of the documents.\n", query)); // Notify the user
			}

			else { // Otherwise:
				if (docs.size() == 1) { // Due to English grammar, the case where there is only one element in the list of numbers is special
					JOptionPane.showMessageDialog(null, String.format("The word \"%s\" was found in document " + docs.get(0) + ".\n", query)); // Tell the user the results of the search
				}
				
				else if (docs.size() == 2) { // Two numbers also gets a special case. Grammar is annoying!
					JOptionPane.showMessageDialog(null, String.format("The word \"%s\" was found in documents " + docs.get(0) + " and " + docs.get(1) + ".\n", query)); // Tell the user the results of the search
				}

				else { // Luckily, the cases where the size of the list of document numbers is greater than or equal to 3 are all similar
					String nums = ""; // nums will contain a string representation of docs

					for (int i = 0; i < docs.size() - 1; i ++) { // Go through each number up to the second last one
						nums += docs.get(i) + ", "; // Add it to nums, along with a comma and space
					}

					nums += "and " + docs.get(docs.size() - 1); // finish off the string representation of the list of numbers

					JOptionPane.showMessageDialog(null, String.format("The word \"%s\" was found in documents " + nums + ".\n", query)); // Tell the user the results of the search
				}
			}
			
			query = JOptionPane.showInputDialog(null, "Enter the word for which to search, or press \"Cancel\" to quit:"); // Get the next query
		}

	}

}
