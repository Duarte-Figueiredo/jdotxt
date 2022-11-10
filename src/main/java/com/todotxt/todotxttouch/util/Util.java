/**
 * This file is part of Todo.txt Touch, an Android app for managing your todo.txt file (http://todotxt.com).
 *
 * Copyright (c) 2009-2013 Todo.txt contributors (http://todotxt.com)
 *
 * LICENSE:
 *
 * Todo.txt Touch is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any
 * later version.
 *
 * Todo.txt Touch is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with Todo.txt Touch.  If not, see
 * <http://www.gnu.org/licenses/>.
 *
 * @author Todo.txt contributors <todotxt@yahoogroups.com>
 * @license http://www.gnu.org/licenses/gpl.html
 * @copyright 2009-2013 Todo.txt contributors (http://todotxt.com)
 */
package com.todotxt.todotxttouch.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;

import com.chschmid.jdotxt.gui.controls.JdotxtToolbar;
import com.todotxt.todotxttouch.TodoException;

public class Util {

	private Util() {
	}

	public static void closeStream(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
				stream = null;
			} catch (IOException e) {
				System.out.print("Close stream exception" + e.getMessage());
			}
		}
	}

	public static boolean isDeviceWritable() {
		return true;
	}

	public static void createParentDirectory(File dest) throws TodoException {
		if (dest == null) {
			throw new TodoException("createParentDirectory: dest is null");
		}
		File dir = dest.getParentFile();
		if (dir != null && !dir.exists()) {
			createParentDirectory(dir);
		}
		if (!dir.exists()) {
			if (!dir.mkdirs()) {
				System.out.print("Could not create dirs: " + dir.getAbsolutePath());
				throw new TodoException("Could not create dirs: "
						+ dir.getAbsolutePath());
			}
		}
	}

	public static void renameFile(File origFile, File newFile, boolean overwrite) {
		if (!origFile.exists()) {
			System.out.print("Error renaming file: " + origFile + " does not exist");
			throw new TodoException("Error renaming file: " + origFile
					+ " does not exist");
		}

		createParentDirectory(newFile);

		if (overwrite && newFile.exists()) {
			if (!newFile.delete()) {
				System.out.print("Error renaming file: failed to delete " + newFile);
				throw new TodoException(
						"Error renaming file: failed to delete " + newFile);
			}
		}

		if (!origFile.renameTo(newFile)) {
			System.out.print("Error renaming " + origFile + " to " + newFile);
			throw new TodoException("Error renaming " + origFile + " to "
					+ newFile);
		}
	}

	public static String join(Collection<?> s, String delimiter) {
		StringBuilder builder = new StringBuilder();
		if (s == null) {
			return "";
		}
		Iterator<?> iter = s.iterator();
		while (iter.hasNext()) {
			builder.append(iter.next());
			if (!iter.hasNext()) {
				break;
			}
			builder.append(delimiter);
		}
		return builder.toString();
	}
	
    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = JdotxtToolbar.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
	public static void prependString(ArrayList<String> list, String prepend) {
		for (int k1=0; k1 < list.size(); k1++) {
			list.set(k1, prepend + list.get(k1));
		}
	}
	
	public static int[] integerList2IntArray(List<Integer> integerlist) {
		int[] array = new int[integerlist.size()];
		for (int k1 = 0; k1 < integerlist.size(); k1++) {
			array[k1] = (int) integerlist.get(k1);
		}
		return array;
	}
}
