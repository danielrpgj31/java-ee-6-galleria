package info.galleria.service.jpa;

import info.galleria.domain.Album;
import info.galleria.service.GenericRepository;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.*;
import javax.persistence.*;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AlbumRepository implements GenericRepository<Album, Long>
{
	@PersistenceContext
	private EntityManager em;

	public AlbumRepository()
	{
	}

	AlbumRepository(EntityManager em)
	{
		this.em = em;
	}

	@Override
	public Album create(Album album)
	{
		em.persist(album);
		return album;
	}

	@Override
	public Album modify(Album album)
	{
		em.find(Album.class, album.getAlbumId());
		Album mergedAlbum = em.merge(album);
		return mergedAlbum;
	}

	@Override
	public void delete(Album album)
	{
		Album foundAlbum = em.find(Album.class, album.getAlbumId());
		foundAlbum.clearUser();
		em.remove(foundAlbum);
	}

	@Override
	public Album findById(Long albumId)
	{
		Album album = em.find(Album.class, albumId);
		return album;
	}

	@Override
	public List<Album> findAll()
	{
		TypedQuery<Album> findAllAlbumsQuery = em.createNamedQuery("info.galleria.domain.Album.findAllAlbums",
				Album.class);
		List<Album> resultList = findAllAlbumsQuery.getResultList();
		return resultList;
	}

	public List<Album> findAllByOwner(String userId)
	{
		TypedQuery<Album> findAllAlbumsQuery = em.createNamedQuery("info.galleria.domain.Album.findAllAlbumsByOwner",
				Album.class);
		findAllAlbumsQuery.setParameter("userId", userId);
		List<Album> resultList = findAllAlbumsQuery.getResultList();
		return resultList;
	}

	public Album findByOwnerAndId(String userId, Long albumId)
	{
		TypedQuery<Album> findAlbumQuery = em.createNamedQuery("info.galleria.domain.Album.findAlbumByOwnerAndId",
				Album.class);
		findAlbumQuery.setParameter("userId", userId);
		findAlbumQuery.setParameter("albumId", albumId);
		Album album = findAlbumQuery.getSingleResult();
		return album;
	}

}
