package com.bms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.dao.BagDao;
import com.bms.model.Bag;


@Repository
public class BagDaoImpl implements BagDao
{
  @Autowired
  private SessionFactory sessionFactory;
  
  @Override
  public void addBag(Bag bag)
  {
    Session session=this.sessionFactory.getCurrentSession();
    session.save(bag);
    
  }

  @Override
  public void updateBag(Bag bag)
  {
    Session session=this.sessionFactory.getCurrentSession();
    session.update(bag);
  }

  @Override
  public void deleteBag(String bid)
  {
    Session session=this.sessionFactory.getCurrentSession();
    Bag bag=(Bag)session.load(Bag.class, new String(bid));
    if(null!=bag){
        session.delete(bag);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Bag> baglist()
  {
    Session session=this.sessionFactory.getCurrentSession();
    List<Bag> baglist=session.createQuery("from Bag").list();
    return baglist;
  }

  @Override
  public Bag getBagById(String bid)
  {
    Session session=this.sessionFactory.getCurrentSession();
    Bag bag=(Bag)session.load(Bag.class, new String(bid));
    return bag;
  }

@Override
public Bag getBagByBagName(String bname) {
    Session session=this.sessionFactory.getCurrentSession();
    Bag bag=(Bag)session.load(Bag.class, new String(bname));
    return bag;
}

@SuppressWarnings("unchecked")
@Override
public List<Bag> searchBag(String searchName) {
	Session session=this.sessionFactory.getCurrentSession();
	List<Bag> baglist=session.createQuery("from Bag where bname like '"+searchName+"%'").list();
	for(Bag bag:baglist){
		System.out.println("bag="+bag.getBname());
		
	}
	System.out.println(baglist);
	return baglist;
	
}


@SuppressWarnings("unchecked")
@Override
public List<Bag> getBagByCategory(String category_cid) {
	Session session=this.sessionFactory.getCurrentSession();
	List<Bag> categorybag=session.createQuery("from Bag where category_catid='"+category_cid+"'").list();
	return categorybag;
}

@SuppressWarnings("unchecked")
@Override
public List<Bag> getBagByBrand(String brand_brandid,int page) {
	
	Session session=this.sessionFactory.getCurrentSession();
	int maxpage=2;
	List<Bag> brandbag=session.createQuery("from Bag where brand_brandid='"+brand_brandid+"'")
						.setFirstResult(page*maxpage).setMaxResults(maxpage).list();
	return brandbag;
}

@SuppressWarnings("unchecked")
@Override
public List<Bag> getPopularBags() {
	Session session=this.sessionFactory.getCurrentSession();
	List<Bag> popBags=session.createQuery("FROM Bag bag ORDER BY bag.bview DESC").setMaxResults(3).list();
	System.out.println("Popular Items="+popBags);
	return popBags;
}

@SuppressWarnings("unchecked")
@Override
public List<Bag> isFeatured() {
	Session session=this.sessionFactory.getCurrentSession();
	List<Bag> ftBags=session.createQuery("FROM Bag where bfeatured=true").list();
	System.out.println(ftBags);
	return ftBags;
}

@SuppressWarnings("unchecked")
@Override
public List<Bag> getBagByCatWithPag(String category_cid, int page) {
	Session session=this.sessionFactory.getCurrentSession();
	int maxpage=2;
	List<Bag> categorybag=session.createQuery("from Bag where category_catid='"+category_cid+"'")
							.setFirstResult(page*maxpage).setMaxResults(maxpage).list();
	return categorybag;
}

@SuppressWarnings("unchecked")
@Override
public List<Bag> getBagByBrandNoPag(String brand_brandid) {
	Session session=this.sessionFactory.getCurrentSession();
	List<Bag> brandbag=session.createQuery("from Bag where brand_brandid='"+brand_brandid+"'").list();
	return brandbag;
	}

}
