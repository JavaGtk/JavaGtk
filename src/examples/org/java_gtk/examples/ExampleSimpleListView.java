package org.java_gtk.examples;

import org.java_gtk.gtk.Box;
import org.java_gtk.gtk.CellRenderer;
import org.java_gtk.gtk.CellRendererText;
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.Label;
import org.java_gtk.gtk.Label.Justification;
import org.java_gtk.gtk.ListStore;
import org.java_gtk.gtk.TreeIterator;
import org.java_gtk.gtk.TreeModel;
import org.java_gtk.gtk.TreeSelection;
import org.java_gtk.gtk.TreeSelection.ChangedEventHandler;
import org.java_gtk.gtk.TreeView;
import org.java_gtk.gtk.TreeViewTextColumn;

/**
 * example code adapted from http://zetcode.com/tutorials/gtktutorial/gtktreeview/
 * 
 * @author Bill
 *
 */
public class ExampleSimpleListView extends ExampleBase {

	Label label;
	TreeView view;
	
	public static void main(String[] args) {
		new ExampleSimpleListView().runExample(args, "Simple ListView Example", 270, 250, 10);
	}

	@Override
	protected void setupExample() {
		view = new TreeView();
		view.setHeadersVisible(false);
		
		Box box = new Box(Orientation.VERTICAL, 0);
		box.packStart(view, true, true, 5);
		
		label = new Label("");
		
		label.setJustification(Justification.CENTER);
		box.packStart(label, false, false, 5);
		
		mainWin.add(box);
		
		ListStore store = initTreeView();
		addItem(store, "Aliens");
		addItem(store, "Leon");
		addItem(store, "Capote");
		addItem(store, "Saving private Ryan");
		addItem(store, "Der Untergang");
		
		TreeSelection selection = view.getSelection();
		selection.addChangedHandler(new ChangedEventHandler() {
			public void handle(TreeSelection source) {
				TreeIterator iter = source.getSelected();
				if (iter != null) {
					ListStore store = (ListStore)view.getModel();
					String value = store.getString(iter, 0);
					label.setText(value);
				}
			}
		});
		
	}
	
	private ListStore initTreeView() {
		CellRendererText renderer = new CellRendererText();
		TreeViewTextColumn column = new TreeViewTextColumn("List Items", renderer, 0);
		view.addColumn(column);
		
		ListStore store = new ListStore(String.class);
		view.setModel(store);
		return store;
	}


	private void addItem(ListStore store, String item) {
		TreeIterator iter = new TreeIterator();
		store.append(iter);
		store.set(iter, 0, item);
	}
}
