package no.hvl.dat102;




//************************************************************
///  Svarer til ein node.
//************************************************************

public class LinearNode<T>{
private LinearNode<T> neste;
private T element;

/**********************************************************
  Lager ein tom node
**********************************************************/
public LinearNode()  {
  neste   =  null;
  element = null;
}

/**********************************************************
  Lager ein node med eit element.
**********************************************************/
public LinearNode (T elem) {
  neste   = null;
  element = elem;
}

/**********************************************************
  Gir tilbake etterfølger.
**********************************************************/
public LinearNode<T> getNeste()  {
  return neste;
}

/**********************************************************
  Settar neste til node
**********************************************************/
public void setNeste (LinearNode<T> node)  {
  neste = node;
}

/**********************************************************
  Returnerar elementet til denne noden
**********************************************************/
public T getElement() {
  return element;
}

/**********************************************************
  Settar nytt element i denne noden.
**********************************************************/
public void setElement (T elem) {
  element = elem;
}
}