package info.galleria.view.photo;

import javax.validation.constraints.Size;

public class EditPhotoRequest
{

	@Size(min = 0, max = 255, message = "{Photo.title.size}")
	private String title;

	@Size(min = 0, max = 255, message = "{Photo.photoDescription.size}")
	private String photoDescription;

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

	public void setPhotoDescription(String photoDescription)
	{
		this.photoDescription = photoDescription;
	}

}
