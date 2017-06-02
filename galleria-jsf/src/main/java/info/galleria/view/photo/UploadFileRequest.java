package info.galleria.view.photo;

import javax.validation.constraints.Size;

import org.primefaces.model.UploadedFile;

public class UploadFileRequest
{
	private long albumId;

	private UploadedFile file;

	@Size(min = 0, max = 255, message = "{Photo.title.size}")
	private String title;

	@Size(min = 0, max = 255, message = "{Photo.photoDescription.size}")
	private String photoDescription;

	public long getAlbumId()
	{
		return albumId;
	}

	public void setAlbumId(long albumId)
	{
		this.albumId = albumId;
	}

	public UploadedFile getFile()
	{
		return file;
	}

	public void setFile(UploadedFile file)
	{
		this.file = file;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getPhotoDescription()
	{
		return photoDescription;
	}

	public void setDescription(String photoDescription)
	{
		this.photoDescription = photoDescription;
	}

}
