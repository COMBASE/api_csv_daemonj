package net.combase.cloud.api.lekkerland.reader;

public class AbstractReader {

	protected String[] readLine(final String sCurrentLine, final int[] fields) {
		final String[] ret = new String[fields.length];
		int lineLengh = 0;
		for (int fieldOffset : fields)
			lineLengh += fieldOffset;
		if (sCurrentLine.length() != lineLengh)
			return null;

		int currOffset = 0;
		int currOffsetEnd = 0;
		for (int i = 0; i < fields.length; i++) {
			currOffsetEnd += fields[i];
			final String currentField = sCurrentLine.substring(currOffset,
					currOffsetEnd);
			ret[i] = currentField;
			currOffset += fields[i];
		}
		return ret;
	}
}
