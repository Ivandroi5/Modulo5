import android.os.Parcel
import android.os.Parcelable
import com.example.alkewalletm5.R

data class LoginUser(
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    var balance: Double = 0.0,
    var imageProfile: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeString(email)
        parcel.writeString(password)
        parcel.writeDouble(balance)
        parcel.writeInt(imageProfile)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginUser> {
        override fun createFromParcel(parcel: Parcel): LoginUser {
            return LoginUser(parcel)
        }

        override fun newArray(size: Int): Array<LoginUser?> {
            return arrayOfNulls(size)
        }


        val dataLoginUsers = mutableListOf<LoginUser>(
            LoginUser(
                name = "Arturo", lastName = "Pendragon", email = "arturo@gmail.com",
                password = "mesaredonda", balance = 1000.0, imageProfile = R.drawable.arturo),

        )
    }
}