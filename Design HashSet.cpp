
class MyHashSet {
private:
    const int SIZE = 100001;
    int *bucket;
public:
    MyHashSet() {
        bucket = new int[this->SIZE];
        for (int i = 0; i < this->SIZE; i++) {
            bucket[i] = -1;
        }
    }

    int hash(int key) {
        return key % this->SIZE;
    }

    void add(int key) {

        bucket[hash(key)] = key;
    }

    void remove(int key) {
        bucket[hash(key)] = -1;
    }

    bool contains(int key) {
        return bucket[hash(key)] != -1;
    }
};