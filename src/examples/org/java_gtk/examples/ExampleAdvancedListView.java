package org.java_gtk.examples;

import org.java_gtk.gtk.Button;
import org.java_gtk.gtk.Button.ClickedEventHandler;
import org.java_gtk.gtk.Container.Orientation;
import org.java_gtk.gtk.Entry;
import org.java_gtk.gtk.Frame.ShadowType;
import org.java_gtk.gtk.Box;
import org.java_gtk.gtk.CellRendererText;
import org.java_gtk.gtk.ListStore;
import org.java_gtk.gtk.ScrolledWindow;
import org.java_gtk.gtk.TreeIterator;
import org.java_gtk.gtk.TreeSelection;
import org.java_gtk.gtk.TreeViewTextColumn;
import org.java_gtk.gtk.ScrolledWindow.PolicyType;
import org.java_gtk.gtk.TreeView;

public class ExampleAdvancedListView extends ExampleBase {

	private TreeView view;
	
	public static void main(String[] args) {
		new ExampleAdvancedListView().runExample(args, "Advanced ListView Example", 370, 270, 10);
	}

	@Override
	protected void setupExample() {
		ScrolledWindow sw = new ScrolledWindow(null, null);
		view = new TreeView();
		
		sw.setPolicy(PolicyType.AUTOMATIC, PolicyType.AUTOMATIC);
		sw.setShadowType(ShadowType.ETCHED_IN);
		view.setHeadersVisible(false);
		
		Box vbox = new Box(Orientation.VERTICAL, 0);
		vbox.packStart(sw, true, true, 5);
		
		Box hbox = new Box(Orientation.HORIZONTAL, 0);
		Button add = new Button("Add");
		Button remove = new Button("Remove");
		Button removeAll = new Button("Remove All");
		final Entry entry = new Entry();
		
		hbox.packStart(add, false, true, 3);
		hbox.packStart(entry, false, true, 3);
		hbox.packStart(remove, false, true, 3);
		hbox.packStart(removeAll, false, true, 3);
		vbox.packStart(hbox, false, true, 3);
		
		sw.add(view);
		mainWin.add(vbox);
		
		initTreeView(view);
		final TreeSelection selection = view.getSelection();
		
		add.addClickedHandler(new ClickedEventHandler() {
			public void handle(Button source) {
				String text = entry.getText();
				ListStore store = (ListStore)view.getModel();
				TreeIterator iter = new TreeIterator();
				store.append(iter);
				store.set(iter, 0, text);
			}
		});
		
		remove.addClickedHandler(new ClickedEventHandler() {
			public void handle(Button source) {
				ListStore store = (ListStore)view.getModel();
				TreeIterator iter = new TreeIterator();
				if (store.getFirstIterator(iter)) {
					iter = selection.getSelected();
					store.remove(iter);
				}
			}
		});
		
		removeAll.addClickedHandler(new ClickedEventHandler() {
			public void handle(Button source) {
				ListStore store = (ListStore)view.getModel();
				TreeIterator iter = new TreeIterator();
				if (store.getFirstIterator(iter)) {
					store.clear();
				}
			}
		});

	}

	private void initTreeView(TreeView view) {
		
		CellRendererText renderer = new CellRendererText();
		TreeViewTextColumn column = new TreeViewTextColumn("", renderer, 0);
		view.addColumn(column);
		
		ListStore store = new ListStore(String.class);
		view.setModel(store);
	}
	
}
