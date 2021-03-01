package graphics.scenery.xtradimensionvr

import com.bc.zarr.ZarrArray
import org.ojalgo.access.StructureAnyD.shape
import com.bc.zarr.ArrayParams
import com.bc.zarr.DataType
import org.nd4j.linalg.factory.Nd4j
import java.awt.image.DataBuffer


class ZarrReader {
    init {
        // my dataset
        val jzarr_array = ZarrArray.open("datasets/array.zarr/obs/n_genes")

        val shape = jzarr_array.shape
        val offset = intArrayOf(2)

        val jarray_item = jzarr_array.read(shape, offset)
        println(jarray_item) // prints as [J@c1590286

        // JZarr documentation example
        val array = ZarrArray.create(ArrayParams().shape(5, 7).fillValue(-9999).dataType(DataType.i4))

        val data = intArrayOf(11, 12, 13, 14, 15, 21, 22, 23, 24, 25, 31, 32, 33, 34, 35)
        val example_shape = intArrayOf(3, 5) // the actual N-D shape of the data
        val example_offset = intArrayOf(2, 0) // and the offset into the original array

        array.write(data, example_shape, example_offset);
        val entireData = array.read() as IntArray

        println(array) //prints as com.bc.zarr.ZarrArray{'/' shape=[5, 7], chunks=[5, 7], dataType=i4, fillValue=-9999, compressor=blosc/cname=lz4/clevel=5/blocksize=0/shuffle=1, store=InMemoryStore, byteOrder=BIG_ENDIAN}

        println(entireData) // prints as [I@e883e0ae

//        val writer: OutputHelper.Writer = OutputHelper.Writer { out ->
//            val buffer: DataBuffer = Nd4j.createBuffer(entireData)
//            out.println(Nd4j.create(buffer).reshape('c', array.shape))
//        }

    }
}

fun main() {
    ZarrReader()
}
