### Bubble Sort
[Bubble sort](https://en.wikipedia.org/wiki/Bubble_sort) is the simplest sorting algorithm. It works by repeatedly swapping an adjacent element if it is in wrong order. The pass through the list is repeated N times where N is the size of the list.

### Merge Sort
Like QuickSort, [Merge sort](https://en.wikipedia.org/wiki/Merge_sort) is a Divide and Conquer algorithm. It divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves. The merge() function is used for merging two halves. The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. See the following C implementation for details.