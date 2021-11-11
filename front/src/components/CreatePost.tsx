import React, { useCallback, useState } from 'react'
import { useCreatePostMutation } from '../generated/graphql';


const CreatePost = (props: any) => {
  const [author, setAuthor] = useState('')
  const [category, setCategory] = useState('')
  const [title, setTitle] = useState('')
  const [content, setContent] = useState('')

  const [state, executeMutation] = useCreatePostMutation()

  const submit = useCallback(() => {
    executeMutation({ author, category, title, content })
  }, [executeMutation, author, category, title, content])

  return (
    <div>
      <div className="flex flex-column mt3">
      <input
          className="mb2"
          value={author}
          onChange={e => setAuthor(e.target.value)}
          type="text"
          placeholder="author"
        />
        <br/>
        <input
          className="mb2"
          value={category}
          onChange={e => setCategory(e.target.value)}
          type="text"
          placeholder="category"
        />
        <br/>
        <input
          className="mb2"
          value={title}
          onChange={e => setTitle(e.target.value)}
          type="text"
          placeholder="title"
        />
        <br/>
        <textarea
          className="mb2"
          value={content}
          onChange={e => setContent(e.target.value)}
          placeholder="content"
        />
      </div>
      <button
        disabled={state.fetching}
        onClick={submit}>
        Submit
      </button>
    </div>
  )
}

export default CreatePost
