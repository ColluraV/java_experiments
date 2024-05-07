package esercizio_30;

import java.io.File;
import java.util.Optional;

public class FileSystemAccessExercize implements FileSystem{

	//La classe FileSystemAccess prevede i seguenti costruttori:

		FileSystemAccessExercize(){
		
		}
		FileSystemAccessExercize(String fileNamePath){
			
		}
		FileSystemAccessExercize(File file){
			
		}
		@Override
		public void setFileNamePath(String path) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getFilePath() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Optional<File> getFileCurrent() {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
		@Override
		public boolean isFile() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isDirectory() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isHidden() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isWriteble() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isReadeble() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Optional<File> folderOwner() {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
		@Override
		public File[] folderFilesName() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public long fileSize() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public long fileSizeNested() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public boolean mkDir(File dirPath) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean mkDir(String dirName) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean exists() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean create(File file) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean emptyDir() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean deleteDir() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean deleteDir(File dirName) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean deleteDir(String dirName) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean delete(File file) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public String[] dirNested(File dir) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String[] dirParents(File dir) {
			// TODO Auto-generated method stub
			return null;
		}
	
}
