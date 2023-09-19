import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usershop.ProductView
import com.example.usershop.databinding.CategoryItemBinding
import com.example.usershop.utility.Category
import com.squareup.picasso.Picasso

class RvCategoryAdapter (private val contactList:java.util.ArrayList<Category>, var context1: Context): RecyclerView.Adapter<RvCategoryAdapter.ViewHolder>() {
    class ViewHolder(val binding: CategoryItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun getItemCount(): Int {
        return  contactList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem= contactList[position]
        holder.binding.apply {
            itemName.text=currentItem.name.toString()
            Picasso.get().load(currentItem.image).into(categoryPhoto)

            rvContainer.setOnClickListener {
                val ProductIntent= Intent(context1, ProductView::class.java)
              //  ProductIntent.putExtra(Extra_Category,currentItem)
                context1.startActivity(ProductIntent)
            }
        }

    }
}