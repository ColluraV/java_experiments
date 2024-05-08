package esercizio_30;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FileSystemAccessExercize implements FileSystem {

	private File actualFile;
	

	FileSystemAccessExercize() {
		this.actualFile = null;
	}

	FileSystemAccessExercize(String fileNamePath) {
		this.actualFile = new File(fileNamePath);
	}

	FileSystemAccessExercize(File file) {
		this.actualFile=file;
	}

	@Override
	public void setFileNamePath(String path) throws FileSystemAccessError {
		try {
			this.actualFile = new File(path);
		} catch (Exception e) {
			throw new FileSystemAccessError("path errato","setFileNamePath",actualFile);
		}
	}

	@Override
	public String getFileName() {
	
		return this.actualFile != null ? this.actualFile.getName():null;
	}

	@Override
	public String getFilePath() {
		return this.actualFile!=null ? this.actualFile.getPath():null;
	}

	@Override
	public Optional<File> getFileCurrent() {
		return Optional.ofNullable(this.actualFile);
	}

	@Override
	public boolean isFile() {
	//	return this.actualFile!=null ? true : false;
		return this.actualFile.isFile();
	}

	@Override
	public boolean isDirectory() {
		
		return this.actualFile.isDirectory();
	}

	@Override
	public boolean isHidden() {
		return this.actualFile.isHidden();
	}

	@Override
	public boolean isWriteble() {
		return this.actualFile.canWrite();
	}

	@Override
	public boolean isReadeble() {
		return this.actualFile.canRead();
	}

	@Override
	public Optional<File> folderOwner() {
		return Optional.ofNullable(this.actualFile.getParentFile());
	}

	@Override
	public File[] folderFilesName() {
		return this.actualFile.listFiles();
	}

	@Override
	public long fileSize() {
		return this.actualFile!= null ? this.actualFile.length():null;
	}

	@Override
	public long fileSizeNested() {
		/* sbagliata ma mi piaceva
		return this.actualFile != null && this.actualFile.isFile() ? actualFile.length() 
				: this.actualFile!=null && this.actualFile.isDirectory() ? actualFile.getTotalSpace()
						:null;*/
		
		if (this.actualFile != null && this.actualFile.isFile()) {
			return actualFile.length();
		}else if(this.actualFile!=null && this.actualFile.isDirectory()) {
			File[] files=this.actualFile.listFiles();
			long totalSize = 0;
			for ( File file : files) {
				totalSize+=file.length();
			}
			return totalSize;
		}else
			
		return 0;
		
		
	}

	@Override
	public boolean mkDir(File dirPath) throws FileSystemAccessError {
		try {
			this.actualFile= new File("dirPath");
			return this.actualFile.mkdir();
		} catch (Exception e) {
			throw new FileSystemAccessError("errore nel file", "mkDir", this.actualFile);
		}
	}

	@Override
	public boolean mkDir(String dirName) throws FileSystemAccessError {
		try {
			this.actualFile= new File(dirName);
			return this.actualFile.mkdir();
		} catch (Exception e) {
			throw new FileSystemAccessError("errore nel nome del file", "mkDir", this.actualFile);
		}
	}

	@Override
	public boolean exists() {
		return this.actualFile.exists();
	}

	@Override
	public boolean create(File file) throws FileSystemAccessError {
		try {
			this.actualFile=file;
			return this.actualFile.createNewFile();
		} catch (IOException e) {
			throw new FileSystemAccessError("errore nel file", "create", this.actualFile);
		}
	}

	@Override
	public boolean emptyDir() {
		if(this.actualFile!=null && this.actualFile.isDirectory()){
			File[] files=this.actualFile.listFiles();
			if (files!=null) {
			for ( File file : files) {
				file.delete();
			}return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteDir() {
		return this.actualFile!=null && this.actualFile.isDirectory()
				?this.actualFile.delete()
				:false;
	}

	@Override
	public boolean deleteDir(File dirName) throws FileSystemAccessError {
		try {
			this.actualFile=dirName;
			return this.actualFile!=null && this.actualFile.isDirectory()
					?this.actualFile.delete()
					:null;
		} catch (Exception e) {
			throw new FileSystemAccessError("errore nel file", "deleteDir", this.actualFile);
		}
	}

	@Override
	public boolean deleteDir(String dirName) throws FileSystemAccessError {
		try {
			this.actualFile=new File("dirName");
			return this.actualFile!=null && this.actualFile.isDirectory()
					?this.actualFile.delete()
					:null;
		} catch (Exception e) {
			throw new FileSystemAccessError("errore nel nome del file", "deleteDir", this.actualFile);
		}
	}

	@Override
	public boolean delete(File file) throws FileSystemAccessError {
		try {
			return this.actualFile!=null && this.actualFile.isFile()
					?this.actualFile.delete()
					:null;
		} catch (Exception e) {
			throw new FileSystemAccessError("errore nel file", "delete", this.actualFile);
		}
	}

	@Override
	public String[] dirNested(File dir) throws FileSystemAccessError {
		try {
			List<String> paths = new ArrayList<>();
			listNestedDirs(dir, "", paths);
			return paths.toArray(new String[0]);
		} catch (Exception e) {
			throw new FileSystemAccessError("errore nel file", "dirNested", this.actualFile);
		}
	}

	private void listNestedDirs(File dir, String parentPath, List<String> paths) {
	        if (dir.isDirectory()) {
	            File[] subDirs = dir.listFiles(File::isDirectory);
	            if (subDirs != null) {
	                for (File subDir : subDirs) {
	                    String path = parentPath + dir.getName() + "/" + subDir.getName();
	                    paths.add(path);
	                    listNestedDirs(subDir, path + "/", paths);
	                }
	            }
	        }
	    }
		

	@Override
	public String[] dirParents(File dir) {
		 if (dir!=null && dir.exists()) {

	        ArrayList<String> parents = new ArrayList<>();
	        File parent = dir;
	        
	        while (parent != null) {
	            parents.add(parent.getName());
	            parent = parent.getParentFile();
	        }

	        parents.add("ROOT");
	        Collections.reverse(parents);
	        return parents.toArray(new String[0]);
	}
		 return null;
	}

}
