
public class StackArrayImpl<T> implements Stack<T>{
	
	private Object[] data;
	private int pointer=-1;

	public StackArrayImpl(){
		data = new Object[2];
	}
	@Override
	public void push(T object){
		if(size() == data.length){
			createAndCopyNewDataStore(data.length*2);
		}
		data[++pointer] = object;
	}

	private void createAndCopyNewDataStore(int size){
		Object[] _tempData = new Object[size];
			copyOldDataTONewArray(_tempData);
			data = _tempData;
	}

	private void copyOldDataTONewArray(Object[] newData){
		int newData_index = 0;
		while(newData_index <= pointer) {
			newData[newData_index] = data[newData_index];
			newData_index++;
		}
	}

	@Override
	public T pop(){
		if(size() < 0) return null;

		Object poped = data[pointer];
		data[pointer] = null;
		--pointer;

		if(size() <= (int)data.length/2){
			int newSize = (int)(data.length*.75);   
			createAndCopyNewDataStore(newSize <2 ?2 : newSize);
		}
		return (T)poped;
	}

	@Override
	public T peek(){
		return (T)data[pointer];
	}

	@Override
	public int size(){
		return pointer+1;
	}

	@Override
	public String toString(){
		StringBuffer stackDataToString = new StringBuffer();
		stackDataToString.append("[");
		int _currentSize = size();
		if(_currentSize > 0){
			int index = 0;
			while(index < _currentSize-1){
				stackDataToString.append(data[index].toString());
				stackDataToString.append(",");
				index++;
			}
			stackDataToString.append(data[_currentSize-1].toString());
		}
		stackDataToString.append("]");
		return stackDataToString.toString();
	}
}
