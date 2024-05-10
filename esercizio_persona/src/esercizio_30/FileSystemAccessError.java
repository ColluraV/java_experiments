package esercizio_30;

import java.io.File;

public class FileSystemAccessError extends Exception {
		private String methodName;
		private File currentFile;
		private Exception e;
		
		public FileSystemAccessError(String message,String methodName) {
			super(message);
			this.methodName = methodName;
		}
		
		public FileSystemAccessError(String message,String methodName, File currentFile) {
			super(message);
			this.methodName = methodName;
			this.currentFile = currentFile;
		}

		public FileSystemAccessError(String message,String methodName, File currentFile, Exception e) {
			super(message);
			this.methodName = methodName;
			this.currentFile = currentFile;
			this.e=e;
		}
		
		/**
		 * @return the methodName
		 */
		public String getMethodName() {
			return methodName;
		}
		/**
		 * @return the currentFile
		 */
		public File getCurrentFile() {
			return currentFile;
		}

		@Override
		public String toString() {
			return "FileSystemAccessError [methodName=" + methodName + ", currentFile=" + currentFile + ", e=" + e
					+ "]";
		}

		
		
}
