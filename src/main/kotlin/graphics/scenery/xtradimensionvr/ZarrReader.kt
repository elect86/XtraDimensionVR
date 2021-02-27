package graphics.scenery.xtradimensionvr

import com.bc.zarr.ZarrArray
import org.ojalgo.access.StructureAnyD.shape
import com.bc.zarr.ArrayParams
import java.awt.image.DataBuffer










class ZarrReader {
    init {
        val zarr_array = ZarrArray.open("datasets/array.zarr/obs/n_genes")

        val shape = zarr_array.shape
        val offset = intArrayOf(2)

        val array_item = zarr_array.read(shape, offset)

        println(array_item)

    }
}

fun main() {
    ZarrReader()
    println("hello world main")
}
